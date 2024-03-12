package com.example.kakaoTest.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class BaseResponse<T> {
    @JsonProperty("isSuccess") private final Boolean isSuccess;
    private final String message;
    private final int code;
    @JsonInclude(JsonInclude.Include.NON_NULL) private T result;


    /**
     * 요청 성공
     */
    public BaseResponse(T result) {
        this.isSuccess = BaseResponseStatus.SUCCESS.isSuccess();
        this.code = BaseResponseStatus.SUCCESS.getCode();
        this.message = BaseResponseStatus.SUCCESS.getMessage();
    }

    /**
     * 요청 실패
     */
    public BaseResponse(BaseResponseStatus status) {
        this.isSuccess = status.isSuccess();
        this.code = status.getCode();
        this.message = status.getMessage();
    }


    /**
     * 직접 설정
     */
    public BaseResponse(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

}
