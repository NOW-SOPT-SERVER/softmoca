package org.spot.pratice.repository;

import org.spot.pratice.common.exception.NotFoundException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.spot.pratice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    default Post findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        );
    }

}
