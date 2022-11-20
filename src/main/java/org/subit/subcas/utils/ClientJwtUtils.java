package org.subit.subcas.utils;


import org.subit.subcas.data.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientJwtUtils extends jwtUtils<Client> {
    @Override
    public String generateToken(Client user) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("clientID", user.getClientID());
        payload.put("cid", user.getCid());
        return buildJwt(payload);
    }
}
