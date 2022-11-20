package org.subit.subcas.exception;

import org.jetbrains.annotations.NotNull;
import org.subit.subcas.dto.ReturnCode;

public class UserForbiddenException extends AuthException {

    public UserForbiddenException() {
    }

    public UserForbiddenException(String message) {
        super(message);
    }

    public UserForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserForbiddenException(Throwable cause) {
        super(cause);
    }

    @Override
    public @NotNull ReturnCode getReturnCode() {
        return null;
    }
}
