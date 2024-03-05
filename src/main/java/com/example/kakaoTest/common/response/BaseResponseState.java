package com.example.kakaoTest.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseState {

    SUCCESS(true, HttpStatus.OK.value(), "요청에 성공하였습니다."),



        ;

    private final boolean isSuccess;
    private final int code;
    private final String message;
    BaseResponseState(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
