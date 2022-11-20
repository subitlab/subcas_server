package org.subit.subcas.filter;

import io.jsonwebtoken.Claims;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.subit.subcas.exception.TokenIllegalException;
import org.subit.subcas.utils.UserJwtUtils;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Value("${subcas.jwt.type}")
    private String tokenType;

    @Resource
    private UserJwtUtils userJwtUtils;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String authenticationString = request.getHeader("Authorization");
        if (!StringUtils.hasText(authenticationString)) {
            filterChain.doFilter(request, response);
            return;
        }
        String[] authenticationPair = authenticationString.split(" ");
        if (authenticationPair.length != 2 || !(Objects.equals(authenticationPair[0], tokenType))) {
            filterChain.doFilter(request, response);
            return;
        }
        Claims userInfo = null;
        try {
            userInfo = userJwtUtils.getTokenInfo(authenticationPair[1]);
        } catch (TokenIllegalException e) {
            System.err.println("Token Pattern Error");
            filterChain.doFilter(request, response);
            return;
        }
        Collection<String> accesses = (Collection<String>) userInfo.get("access");
        List<SimpleGrantedAuthority> authorityList = accesses.stream().map(SimpleGrantedAuthority::new).toList();
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(userInfo, null, authorityList));
        filterChain.doFilter(request, response);
    }
}
