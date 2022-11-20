package org.subit.subcas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.subit.subcas.exception.SubcasBaseException;

@Setter
@Getter
@AllArgsConstructor
public class Result {
    private int code;
    private Object data;

    Result(ReturnCode code, Object data) {
        this.code = code.getCode();
        if (code != ReturnCode.success) {
            this.data = code.getMessage();
            return;
        }
        this.data = data;
    }

    @Contract("_ -> new")
    public static @NotNull Result success(Object data) {
        return new Result(ReturnCode.success, data);
    }

    @Contract("_ -> new")
    public static @NotNull Result error(@NotNull Exception e) {
        return new Result(ReturnCode.UnknownError.getCode(), e.getClass().getName() + " " + e.getMessage());
    }

    @Contract("_ -> new")
    public static @NotNull Result code(@NotNull ReturnCode c) {
        return new Result(c.getCode(), c.getMessage());
    }

    @Contract("_ -> new")
    public static @NotNull Result failed(@NotNull SubcasBaseException e) {
        return new Result(e.getReturnCode(), null);
    }
}
