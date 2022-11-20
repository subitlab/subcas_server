package org.subit.subcas.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNull;
import org.subit.subcas.dto.ReturnCode;

public abstract class SubcasBaseException extends Exception {
    public SubcasBaseException() {
    }

    public SubcasBaseException(String message) {
        super(message);
    }

    public SubcasBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubcasBaseException(Throwable cause) {
        super(cause);
    }

    @NonNull
    abstract public @NotNull ReturnCode getReturnCode();
}
