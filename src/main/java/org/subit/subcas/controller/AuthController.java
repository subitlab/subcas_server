package org.subit.subcas.controller;

import org.springframework.web.bind.annotation.*;
import org.subit.subcas.dto.Result;
import org.subit.subcas.dto.UserDTO;
import org.subit.subcas.exception.ClientNotRegisterException;
import org.subit.subcas.exception.UserForbiddenException;
import org.subit.subcas.exception.UsernamePasswordNotMatchException;
import org.subit.subcas.service.AuthorizationService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * The Authorization service.
     */
    @Resource
    AuthorizationService authorizationService;

    /**
     * Login result.
     *
     * @param user the user
     * @return the result
     * @throws UsernamePasswordNotMatchException the username password not match exception
     * @throws UserForbiddenException            the user forbidden exception
     */
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO user) throws UsernamePasswordNotMatchException, UserForbiddenException {
        String token = authorizationService.login(user);
        Map<String, String> result = new HashMap<>();
        result.put("token", token);
        return Result.success(result);
    }

    /**
     * Redirect result.
     *
     * @param client_id the client id
     * @return the result
     * @throws ClientNotRegisterException the client not register exception
     */
    @GetMapping("/redirect")
    public Result redirect(@RequestParam String client_id) throws ClientNotRegisterException {
        String redirect = authorizationService.redirect(client_id);
        return Result.success(redirect);
    }

    /**
     * Gets auth code.
     *
     * @return the auth code
     */
    @GetMapping("/code")
    public Result getAuthCode() {
        return Result.success("123");
    }
}
