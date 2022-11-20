package org.subit.subcas.service;

import org.subit.subcas.dto.UserDTO;
import org.subit.subcas.exception.ClientNotRegisterException;
import org.subit.subcas.exception.UserForbiddenException;
import org.subit.subcas.exception.UsernamePasswordNotMatchException;

public interface AuthorizationService {
    String login(UserDTO user) throws UsernamePasswordNotMatchException, UserForbiddenException;

    String redirect(String ClientID) throws ClientNotRegisterException;
}
