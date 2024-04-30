package org.spot.pratice.service.dto;

import org.spot.pratice.domain.Member;
import org.spot.pratice.domain.Post;

public record PostFindDto(
        String title,
        String content
) {
    public static PostFindDto of(Post post){
        return new PostFindDto(
                post.getTitle(),
                post.getContent()
        );
    }
}

