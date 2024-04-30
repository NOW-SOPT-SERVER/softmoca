package org.spot.pratice.service.dto;

import org.spot.pratice.domain.Blog;

public record BlogFindDto(
        String title,
        String description,
        MemberFindDto member
) {
    public static BlogFindDto of(Blog blog) {
        return new BlogFindDto(
                blog.getTitle(),
                blog.getDescription(),
                MemberFindDto.of(blog.getMember())
        );
    }
}