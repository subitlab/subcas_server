package org.subit.subcas.exception;

import org.jetbrains.annotations.NotNull;
import org.subit.subcas.dto.ReturnCode;

public class ClientNotRegisterException extends AuthException {
    public ClientNotRegisterException() {
    }

    public ClientNotRegisterException(String message) {
        super(message);
    }

    public ClientNotRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientNotRegisterException(Throwable cause) {
        super(cause);
    }

    @Override
    public @NotNull ReturnCode getReturnCode() {
        return ReturnCode.UnrecognizedClient;
    }
}
