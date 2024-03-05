package com.example.kakaoTest.kakaopay.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoReadyResponse {
    private String tid;     // 결제 고유 번호
    private String next_redirect_pc_url;        // pc 웹 결제페이지 url
    private String created_at;      // 결제 준비 요청 시간
}
