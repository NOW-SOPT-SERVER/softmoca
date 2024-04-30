package org.spot.pratice.service.dto;

import jakarta.validation.constraints.Size;

public record BlogTitleUpdateRequestDTO(

        @Size(max=100,message="최대글자 100개입니다 !!!")
        String title
) {
}
