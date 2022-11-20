package org.subit.subcas.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.subit.subcas.exception.TokenIllegalException;

import java.util.Date;
import java.util.Map;

public abstract class jwtUtils<T> {
    @Value("${subcas.jwt.expired}")
    private Long expired_time;

    @Value("${subcas.jwt.secret}")
    private String secret;

    public long getExpired_time() {
        return expired_time;
    }

    public String buildJwt(Map<String, Object> payload) {
        return Jwts.builder()
                .addClaims(payload)
                .setExpiration(new Date(System.currentTimeMillis() + expired_time))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public abstract String generateToken(T user);

    public Claims getTokenInfo(String token) throws TokenIllegalException {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException |
                 IllegalArgumentException e) {
            throw new TokenIllegalException(e);
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parse(token);
            return true;
        } catch (ExpiredJwtException | IllegalArgumentException | SignatureException | MalformedJwtException e) {
            return false;
        }
    }
}
