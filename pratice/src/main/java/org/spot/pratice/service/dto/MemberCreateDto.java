package org.spot.pratice.service.dto;

import org.spot.pratice.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
