package org.spot.pratice.common.exception;

import lombok.Getter;
import org.postgresql.util.ServerErrorMessage;
import org.spot.pratice.common.exception.message.ErrorMessage;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
