package org.bootstrap.search.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements BaseErrorCode {

    /* global error */
    HTTP_MESSAGE_NOT_READABLE(BAD_REQUEST,"GLOBAL_400_1", "잘못된 형식의 값을 입력했습니다."),
    _INTERNAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, "GLOBAL_500_1", "서버 오류. 관리자에게 문의 부탁드립니다."),

    /* Search error */
    ELASTIC_SEARCH_QUERY_ERROR(INTERNAL_SERVER_ERROR, "SEARCH_500_1", "엘라스틱서치 쿼리에서 문제가 발생했습니다."),

    /*Enum error*/
    INVALID_ENUM_CODE(BAD_REQUEST, "ENUM_400_1", "잘못된 Enum class code 입니다.");

    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);
    }
}
