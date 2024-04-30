package org.spot.pratice.service;

import lombok.RequiredArgsConstructor;
import org.spot.pratice.common.exception.NotFoundException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.spot.pratice.domain.Blog;
import org.spot.pratice.domain.Member;
import org.spot.pratice.repository.BlogRepository;
import org.spot.pratice.service.dto.BlogCreateRequestDTO;
import org.spot.pratice.service.dto.BlogTitleUpdateRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String create(Long memberId, BlogCreateRequestDTO blogCreateRequest) {
        //member찾기
        Member member = memberService.findMemberById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }




    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequestDTO blogTitleUpdateRequest) {
        Blog blog = findBlogById(blogId);

        blog.updateTitle(blogTitleUpdateRequest.title());
    }


    @Transactional(readOnly = true)
    protected Blog findBlogById(final Long blogId) {
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND));
    }




}
