package com.example.kakaoTest.kakaopay;

import com.example.kakaoTest.kakaopay.request.PayInfoDto;
import com.example.kakaoTest.kakaopay.request.RefundDto;
import com.example.kakaoTest.kakaopay.response.KakaoApproveResponse;
import com.example.kakaoTest.kakaopay.response.KakaoCancelResponse;
import com.example.kakaoTest.kakaopay.response.KakaoReadyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class KakaoPayController {
    private final KakaoPayService kakaoPayService;

    /**\
     * 결제 요청
     */
    @PostMapping("/ready")
    public ResponseEntity<KakaoReadyResponse> readyToKakaoPay(@RequestBody PayInfoDto payInfoDto) {
        KakaoReadyResponse kakaoReadyResponse = kakaoPayService.kakaoPayReady(payInfoDto);
        return ResponseEntity.ok(kakaoReadyResponse);
    }

    /**
     * 결제 승인
     */
    @GetMapping("/success")
    public ResponseEntity<KakaoApproveResponse> afterPayRequest(@RequestParam("pg_token") String pgToken) {
        KakaoApproveResponse kakaoApproveResponse = kakaoPayService.ApproveResponse(pgToken);
        return ResponseEntity.ok(kakaoApproveResponse);
    }

    /**
     * 결제 진행 중 취소
     */
    public void cancel() {

    }

    /**
     * 결제 실패
     */
    public void fail() {

    }

    /**
     * 환불
     * tid, cancel_amount -> RefundDto
     */
    @PostMapping("/refund")
    public ResponseEntity<KakaoCancelResponse> refund(@RequestBody RefundDto refundDto) {
        KakaoCancelResponse kakaoCancelResponse = kakaoPayService.kakaoCancel(refundDto);
        return new ResponseEntity<>(kakaoCancelResponse, HttpStatus.OK);
    }
}
