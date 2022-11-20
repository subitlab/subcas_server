package org.subit.subcas.exception;

import org.jetbrains.annotations.NotNull;
import org.subit.subcas.dto.ReturnCode;

public class UsernamePasswordNotMatchException extends AuthException {

    public UsernamePasswordNotMatchException() {
    }

    public UsernamePasswordNotMatchException(String message) {
        super(message);
    }

    public UsernamePasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernamePasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    @Override
    public @NotNull ReturnCode getReturnCode() {
        return ReturnCode.WrongUsernameOrPassword;
    }
}
