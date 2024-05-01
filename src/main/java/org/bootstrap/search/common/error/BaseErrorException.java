package org.bootstrap.search.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.ErrorResponse;

@Getter
@AllArgsConstructor
public class BaseErrorException extends RuntimeException{

    private BaseErrorCode errorCode;

    public ErrorReason getErrorReason() {
        return this.errorCode.getErrorReason();
    }
}
