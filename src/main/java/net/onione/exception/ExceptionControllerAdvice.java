package net.onione.exception;

import lombok.extern.slf4j.Slf4j;
import net.onione.model.vo.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleOnioneException(Exception e) {
        return ResponseEntity.ok(ApiResponse.fail());  // 서버에서 명시적으로 처리 할수 없는 오류
    }


    @ExceptionHandler(BizRuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleBizRuntimeException(BizRuntimeException e) {
        ApiResponse<Object> fail = ApiResponse.fail(e.getApiResponseCode());
        return new ResponseEntity<>(fail, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InValidResponseException.class)
    public ResponseEntity<ApiResponse<Object>> handleInValidResponseException(InValidResponseException e) {
        ApiResponse<Object> fail = ApiResponse.fail(e.getApiResponseCode());
        return new ResponseEntity<>(fail, HttpStatus.BAD_REQUEST);
    }

}