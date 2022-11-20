package org.subit.subcas.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.subit.subcas.data.Access;
import org.subit.subcas.data.Account;
import org.subit.subcas.exception.TokenIllegalException;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserJwtUtils extends jwtUtils<Account> {

    public String generateToken(Account user) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", user.getId());
        payload.put("username", user.getUsername());
        payload.put("nickname", user.getNickname());
        payload.put("role", user.getRole().getRoleName());
        System.out.println(user.getRole().getAccesses().stream().map(Access::getName));
        payload.put("access", user.getRole().getAccesses().stream().map(Access::getName).toList());
        return buildJwt(payload);
    }


    public Long getId(String token) throws TokenIllegalException {
        Claims payload = getTokenInfo(token);
        return (Long) payload.get("id");
    }
}
