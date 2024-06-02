package org.spot.pratice.common.exception;

import org.spot.pratice.common.exception.message.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
