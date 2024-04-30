package org.spot.pratice.common.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 없습니다"),
    BLOG_NOT_FOUND(HttpStatus.NO_CONTENT.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 포스트가 존재하지 않습니다."),
    FORBIDDEN_MEMBER(HttpStatus.FORBIDDEN.value(), "블로그 주인만 글을 작성할수 있습니다");
    private final int status;
    private final String message;
}
