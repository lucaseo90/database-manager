package io.github.hsseo0501.databasemanager.type;

import io.github.hsseo0501.databasemanager.util.HashMapUtil;
import org.springframework.http.HttpStatus;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ResultCode {
    SUCCESS(HttpStatus.OK, 200, HttpStatus.OK.getReasonPhrase()),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, HttpStatus.BAD_REQUEST.getReasonPhrase()),

    UNDEFINED_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Unknown Error: %s"),

    ;

    private HttpStatus httpStatus;
    private int code;
    private String defaultMessage;

    private static final Map<Integer, ResultCode> lookup = new HashMap<Integer, ResultCode>(HashMapUtil.getCapacity(24));

    static {
        for (ResultCode type : EnumSet.allOf(ResultCode.class)) {
            lookup.put(type.getCode(), type);
        }
    }

    ResultCode(HttpStatus httpStatus, int code, String defaultMessage) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public static ResultCode get(int code) {
        return lookup.get(code);
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
