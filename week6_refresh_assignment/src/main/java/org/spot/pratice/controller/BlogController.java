package org.spot.pratice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.spot.pratice.auth.PrincipalHandler;
import org.spot.pratice.common.dto.SuccessMessage;
import org.spot.pratice.common.dto.SuccessStatusResponse;
import org.spot.pratice.service.BlogService;
import org.spot.pratice.service.dto.BlogCreateRequest;
import org.spot.pratice.service.dto.BlogTitleUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    private final PrincipalHandler principalHandler;


    @PostMapping("/blog")
    public ResponseEntity createBlog(
            @ModelAttribute BlogCreateRequest blogCreateRequest
    ) {
        return ResponseEntity.created(URI.create(blogService.create(
                principalHandler.getUserIdFromPrincipal(), blogCreateRequest))).build();
    }


    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUdpateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUdpateRequest);
        return ResponseEntity.noContent().build();
    }
}



