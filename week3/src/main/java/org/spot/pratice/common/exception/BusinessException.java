package org.spot.pratice.common.exception;

import org.postgresql.util.ServerErrorMessage;
import org.spot.pratice.common.exception.message.ErrorMessage;

public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
