package com.example.kakaoTest.kakaopay.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PayInfoDto {
    @NotNull private int quantity;
    @NotNull private int total_amount;
}

