package net.onione.exception;

import lombok.Getter;
import net.onione.code.ApiResponseCode;

/**
 * packageName    : net.onione.exception
 * fileName       : BizRuntimeException
 * author         : hanumoka
 * date           : 2/19/24
 * description    : http status code 400 에러를 처리하기 위한 RuntimeException 최상위 공통 비지니스 예외
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/19/24        hanumoka       최초 생성
 */
@Getter
public class BizRuntimeException extends RuntimeException {
    private final ApiResponseCode apiResponseCode;

    public BizRuntimeException(){
        super(ApiResponseCode.FAIL.getMessage());
        this.apiResponseCode = ApiResponseCode.FAIL;
    }

    public BizRuntimeException(ApiResponseCode apiResponseCode) {
        super(apiResponseCode.getMessage());
        this.apiResponseCode = apiResponseCode;
    }

    public BizRuntimeException(ApiResponseCode apiResponseCode, String detailMessage) {
        super(detailMessage);
        this.apiResponseCode = apiResponseCode;
    }

    public BizRuntimeException(ApiResponseCode apiResponseCode, Exception originException) {
        super(apiResponseCode.getMessage(), originException);
        this.apiResponseCode = apiResponseCode;
    }
}
