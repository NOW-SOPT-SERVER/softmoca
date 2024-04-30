package org.spot.pratice.common.exception;

import org.spot.pratice.common.exception.message.ErrorMessage;

public class ForbiddenException extends BusinessException{
    public ForbiddenException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}