package net.onione.code;


import lombok.Getter;

/**
 * packageName    : net.onione.code
 * fileName       : ApiCode
 * author         : hanumoka
 * date           : 2/17/24
 * description    : ApiResponse 응답 코드
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/17/24        hanumoka       최초 생성
 */
@Getter
public enum ApiResponseCode {
    SUCCESS(0, "성공"),
    FAIL(4000, "실패"),
    FAIL_INVALID_RESPONSE(4001, "실패"),
    ;

    private final int code;
    private final String message;

    ApiResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
