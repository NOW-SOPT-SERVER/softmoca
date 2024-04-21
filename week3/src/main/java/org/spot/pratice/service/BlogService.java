package org.spot.pratice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spot.pratice.common.exception.NotFoundException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.spot.pratice.domain.Blog;
import org.spot.pratice.domain.Member;
import org.spot.pratice.repository.BlogRepository;
import org.spot.pratice.service.dto.BlogCreateRequest;
import org.spot.pratice.service.dto.BlogTitleUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        //member찾기
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }




    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findBlogById(blogId);

        blog.updateTitle(blogTitleUpdateRequest.title());
    }


    public Blog findBlogById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
        );
    }


}
