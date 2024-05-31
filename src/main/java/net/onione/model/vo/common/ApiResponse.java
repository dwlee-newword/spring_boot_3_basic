package net.onione.model.vo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.onione.code.ApiResponseCode;
import net.onione.exception.InValidResponseException;


/**
 * packageName    : net.onione.model.vo.common
 * fileName       : ApiResponse
 * author         : hanumoka
 * date           : 2/17/24
 * description    : RestApi 공통 응답 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/17/24        hanumoka       최초 생성
 */
@Getter
@Builder
@AllArgsConstructor
public class ApiResponse<T> {

    private ApiResponseCode code;
    private String message;
    private T data;
    private String path;

    public static <T> ApiResponse<T> success() {
        return ApiResponse.<T>builder()
                .code(ApiResponseCode.SUCCESS)
                .message(ApiResponseCode.SUCCESS.getMessage())
                .data(null)
                .build();
    }

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code(ApiResponseCode.SUCCESS)
                .message(ApiResponseCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String successMessage) {
        return ApiResponse.<T>builder()
                .code(ApiResponseCode.SUCCESS)
                .message(successMessage)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> fail() {
        return ApiResponse.<T>builder()
                .code(ApiResponseCode.FAIL)
                .message(ApiResponseCode.FAIL.getMessage())
                .build();
    }

    public static <T> ApiResponse<T> fail(String failMessage) {
        return ApiResponse.<T>builder()
                .code(ApiResponseCode.FAIL)
                .message(failMessage)
                .build();
    }

    public static <T> ApiResponse<T> fail(ApiResponseCode code) {
        return ApiResponse.<T>builder()
                .code(code)
                .message(code.getMessage())
                .build();
    }

    public static <T> ApiResponse<T> fail(ApiResponseCode code, String failMessage) {
        return ApiResponse.<T>builder()
                .code(code)
                .message(failMessage)
                .build();
    }

    public int getCode() {
        return code.getCode();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void validate() {
        if(this.data != null && this.data instanceof BaseOutVO){
            if(!((BaseOutVO) this.data).responseValidate()){
                throw new InValidResponseException();
            }
        }
    }
}
