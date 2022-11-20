package org.subit.subcas.exception;

import org.jetbrains.annotations.NotNull;
import org.subit.subcas.dto.ReturnCode;

public class TokenIllegalException extends AuthException {
    public TokenIllegalException() {
    }

    public TokenIllegalException(String message) {
        super(message);
    }

    public TokenIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenIllegalException(Throwable cause) {
        super(cause);
    }

    @Override
    public @NotNull ReturnCode getReturnCode() {
        return ReturnCode.InvalidToken;
    }
}
