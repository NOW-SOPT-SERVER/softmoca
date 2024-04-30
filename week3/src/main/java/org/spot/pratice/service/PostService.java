package org.spot.pratice.service;


import lombok.RequiredArgsConstructor;
import org.spot.pratice.common.exception.ForbiddenException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.spot.pratice.domain.Blog;
import org.spot.pratice.domain.Post;
import org.spot.pratice.repository.PostRepository;
import org.spot.pratice.service.dto.PostCreateRequestDTO;
import org.spot.pratice.service.dto.PostFindAllDto;
import org.spot.pratice.service.dto.PostFindDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final BlogService blogService;
    private final PostRepository postRepository;

    @Transactional
    public String createPost(final Long memberId, final Long blogId, final PostCreateRequestDTO postCreateRequest) {
        Blog blog = blogService.findBlogById(blogId);

        if (!blog.getMember().getId().equals(memberId)) {
            throw new ForbiddenException(ErrorMessage.FORBIDDEN_MEMBER);
        }

        Post post = postRepository.save(Post.create(blog, postCreateRequest.title(), postCreateRequest.content()));
        return post.getId().toString();
    }

    public PostFindDto findPostById(Long postId) {
        return PostFindDto.of(postRepository.findByIdOrThrow(postId));
    }

    @Transactional(readOnly = true)
    public List<PostFindAllDto> findAllPosts() {
        return PostFindAllDto.listOf(postRepository.findAll());
    }


}
