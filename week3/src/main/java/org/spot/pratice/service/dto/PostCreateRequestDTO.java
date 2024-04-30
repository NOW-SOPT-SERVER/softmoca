package org.spot.pratice.service.dto;

import jakarta.validation.constraints.Size;

public record PostCreateRequestDTO(

        @Size(max = 10, message = "게시글 제목이은 10 글자 이상 작성할 수 없습니다 !")
        String title,

        @Size(max = 100, message = "게시글을 100글자 이상 작성할수 없습니다!!")
        String content
) {
}
