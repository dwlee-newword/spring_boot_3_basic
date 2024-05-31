package net.onione.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import net.onione.model.vo.common.ApiResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 응답값에 requestUrl 추가
 *
 * @author : KYB
 * @fileName : ApiResponseAspect
 * @since : 2024-02-20
 */
@Slf4j
@Aspect
@Component
public class ApiResponseAspect {

    @AfterReturning(pointcut = "execution(* net.onione.controller..*.*(..))", returning = "result")
    public void validateApiResponse(Object result) {
        if (result instanceof ResponseEntity) {
            ResponseEntity responseEntity = (ResponseEntity) result;
            Object body = responseEntity.getBody();
            if (body instanceof ApiResponse<?>) {
                ((ApiResponse<?>) body).validate();
            }//if
        }//if
    } //validateApiResponse

    @Around("execution(* net.onione.controller..*.*(..))")
    public Object handleApiResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed(); // 타겟 메서드 실행

        // ResponseEntity 인스턴스인 경우 내부의 ApiResponse<?> 처리
        if (proceed instanceof ResponseEntity) {
            ResponseEntity<?> responseEntity = (ResponseEntity<?>) proceed;
            Object body = responseEntity.getBody();

            // body가 ApiResponse<?> 인스턴스인 경우
            if (body instanceof ApiResponse) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String requestUrl = request.getRequestURL().toString();

                // 새로운 ApiResponse<?> 생성 또는 기존 ApiResponse<?> 수정
                ApiResponse<?> apiResponse = (ApiResponse<?>) body;
                apiResponse.setPath(requestUrl); // 요청 URL 설정

                // 수정된 ApiResponse<?>를 포함하는 새로운 ResponseEntity<?> 반환
                return new ResponseEntity<>(apiResponse, responseEntity.getHeaders(), responseEntity.getStatusCode());
            }//if
        }//if

        return proceed;
    } //handleApiResponse
}