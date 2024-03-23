package com.example.kakaoTest.kakaopay.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RefundDto {
    @NotNull private String tid;
    @NotNull private int cancel_amount;      // 취소 금액
}