package org.spot.pratice.service.dto;

import jakarta.validation.constraints.Size;

public record BlogTitleUpdateRequest(

        @Size(max=100,message="최대글자 100개임 조절해주세요")
        String title
) {
}
