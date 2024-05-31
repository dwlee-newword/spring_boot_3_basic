package net.onione.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.onione.model.vo.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 헬스체크용
 *
 * @author : KYB
 * @fileName : HealthCheckController
 * @since : 2024-02-21
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/health-check")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> healthCheck() {
        return ResponseEntity.ok(ApiResponse.success());
    }
}
