package org.spot.pratice.auth;

import org.spot.pratice.common.exception.UnauthorizedException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class PrincipalHandler {

    private static final String ANONYMOUS_USER = "anonymousUser";

    public Long getUserIdFromPrincipal() {
        // 현재 인증된 사용자의 Principal 객체를 가져오기.
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        isPrincipalNull(principal);   // Principal 객체가 null이거나 익명의 사용자일 경우 예외를 던지기.
        return Long.valueOf(principal.toString());
    }

    public void isPrincipalNull(
            final Object principal
    ) {
        if (principal.toString().equals(ANONYMOUS_USER)) {
            throw new UnauthorizedException(ErrorMessage.JWT_UNAUTHORIZED_EXCEPTION);
        }
    }
}