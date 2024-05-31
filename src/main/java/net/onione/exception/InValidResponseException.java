package net.onione.exception;

import lombok.Getter;
import net.onione.code.ApiResponseCode;

/**
 * 컨트롤러 응답 값 벨리데이셩 실패시 발생하는 예외
 *
 * @author : KYB
 * @fileName : InValidResponseException
 * @since : 2024-02-20
 */
@Getter
public class InValidResponseException extends BizRuntimeException{

    private final ApiResponseCode apiResponseCode;

    public InValidResponseException(){
        super(ApiResponseCode.FAIL_INVALID_RESPONSE);
        this.apiResponseCode = ApiResponseCode.FAIL_INVALID_RESPONSE;
    }

    public InValidResponseException(ApiResponseCode apiResponseCode, ApiResponseCode apiResponseCode1) {
        super(apiResponseCode);
        this.apiResponseCode = apiResponseCode1;
    }

    public InValidResponseException(ApiResponseCode apiResponseCode, String detailMessage, ApiResponseCode apiResponseCode1) {
        super(apiResponseCode, detailMessage);
        this.apiResponseCode = apiResponseCode1;
    }

    public InValidResponseException(ApiResponseCode apiResponseCode, Exception originException, ApiResponseCode apiResponseCode1) {
        super(apiResponseCode, originException);
        this.apiResponseCode = apiResponseCode1;
    }
}
