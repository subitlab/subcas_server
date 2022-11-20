package org.subit.subcas.dto;

public enum ReturnCode {
    NoPrivileges(10001, "request forbidden"),
    UnknownError(10002, "unknown error"),
    WrongUsernameOrPassword(10003, "username or password error"),
    NotMatchedPassword(10004, "password incorrect"),


    InvalidArgument(10008, "Argument Invalid"),
    InvalidToken(10009, "Token Invalid"),
    InvalidMethod(10010, "Invalid Method"),

    PasswordNotMatch(10011, "Password Not Match"),

    UnknownRecord(10014, "Record Does Not Exist"),
    InvalidData(10015, "Data Invalid, Check for duplicate sid"),

    SystemOff(10016, "System Is No Open"),
    StrategyLimit(10017, "Forbidden Due To SignUp Strategy"),
    success(10000, "success"),
    InvalidAuthenticationType(10020, "Authentication Type Error. should be Bearer"),
    UnrecognizedClient(10021, "Unrecognized client"),

    testAPI(90000, "接口测试");

    private final int code;
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
