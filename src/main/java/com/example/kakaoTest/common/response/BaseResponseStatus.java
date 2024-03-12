package com.example.kakaoTest.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseStatus {

    /** 성공 2xx */
    SUCCESS(true, HttpStatus.OK.value(), "요청에 성공하였습니다"),


    /** client error - 4xx */
    EXIST_EMAIL(false, HttpStatus.CONFLICT.value(), "이미 존재하는 회원입니다"),
    NON_EXIST_USER(false, HttpStatus.NOT_FOUND.value(), "존재하지 않는 회원입니다"),
    WRONG_PASSWORD(false, HttpStatus.BAD_REQUEST.value(), "잘못된 비밀번호 입니다."),
    EXIST_NICKNAME(false, HttpStatus.CONFLICT.value(), "이미 존재하는 이름입니다."),
    NON_EXIST_PAYMENT(false, HttpStatus.NOT_FOUND.value(), "결제 내역이 존재하지 않습니다."),
    WRONG_CANCEL_PAYMENT(false, HttpStatus.BAD_REQUEST.value(), "취소 금액이 올바르지 않습니다."),

    /** server error - 5xx */
    DATABASE_INSERT_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터베이스 저장에 실패하였습니다."),

    ;

    private final boolean isSuccess;
    private final int code;
    private final String message;
    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
