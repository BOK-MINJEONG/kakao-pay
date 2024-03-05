package com.example.kakaoTest.common.exception;

import com.example.kakaoTest.common.response.BaseResponseState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {
    private BaseResponseState status;

    public BaseException(BaseResponseState status) {
        super(status.getMessage());
        this.status = status;
    }
}
