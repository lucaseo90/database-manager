package io.github.hsseo0501.databasemanager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsseo0501.databasemanager.type.ResultCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractResponse {

    public static class Response {
        public static final String SUCCESS = "SUCCESS";
        public static final String FAIL = "FAIL";
    }

    String status;

    int code;

    String message;

    Object data;

    public String makeJson(ResultCode resultCode) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.status = resultCode.getHttpStatus() == HttpStatus.OK
                ? Response.SUCCESS : Response.FAIL;
        this.code = resultCode.getCode();
        return objectMapper.writeValueAsString(this);
    }

    public String makeJsonUsingMessage(ResultCode resultCode, String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.status = resultCode.getHttpStatus() == HttpStatus.OK
                ? Response.SUCCESS : Response.FAIL;
        this.code = resultCode.getCode();
        if (resultCode.getHttpStatus() == HttpStatus.OK) {
            this.message = message;
        } else {
            this.message = String.format(resultCode.getDefaultMessage(), message);
        }
        return objectMapper.writeValueAsString(this);
    }

    public String makeJsonUsingData(ResultCode resultCode, Object data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.status = resultCode.getHttpStatus() == HttpStatus.OK
                ? Response.SUCCESS : Response.FAIL;
        this.code = resultCode.getCode();
        this.message = String.format(resultCode.getDefaultMessage(), message);
        this.data = data;
        return objectMapper.writeValueAsString(this);
    }
}
