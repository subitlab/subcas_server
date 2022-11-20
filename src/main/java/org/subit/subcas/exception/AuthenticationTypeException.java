package org.subit.subcas.exception;

import org.jetbrains.annotations.NotNull;
import org.subit.subcas.dto.ReturnCode;

public class AuthenticationTypeException extends AuthException {
    public AuthenticationTypeException() {
    }

    public AuthenticationTypeException(String message) {
        super(message);
    }

    public AuthenticationTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationTypeException(Throwable cause) {
        super(cause);
    }

    @Override
    public @NotNull ReturnCode getReturnCode() {
        return null;
    }
}
