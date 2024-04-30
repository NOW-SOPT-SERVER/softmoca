package org.spot.pratice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.spot.pratice.common.dto.SuccessMessage;
import org.spot.pratice.common.dto.SuccessStatusResponse;
import org.spot.pratice.service.BlogService;
import org.spot.pratice.service.dto.BlogCreateRequestDTO;
import org.spot.pratice.service.dto.BlogTitleUpdateRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog") //블로그 생성
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader Long memberId,
            @RequestBody BlogCreateRequestDTO blogCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        blogService.create(memberId, blogCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }


    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequestDTO blogTitleUdpateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUdpateRequest);
        return ResponseEntity.noContent().build();
    }
}



