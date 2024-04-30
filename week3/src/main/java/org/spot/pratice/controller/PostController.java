package org.spot.pratice.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.spot.pratice.common.dto.SuccessMessage;
import org.spot.pratice.common.dto.SuccessStatusResponse;
import org.spot.pratice.service.PostService;
import org.spot.pratice.service.dto.PostCreateRequestDTO;
import org.spot.pratice.service.dto.PostFindAllDto;
import org.spot.pratice.service.dto.PostFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody PostCreateRequestDTO postCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        postService.createPost(memberId, blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<SuccessStatusResponse<PostFindDto>> findPostById(@PathVariable Long postId) {
        return ResponseEntity.status(HttpStatus.OK).body(SuccessStatusResponse.of(
                SuccessMessage.POST_FIND_SUCCESS,
                postService.findPostById(postId)));
    }

    @GetMapping("/posts")
    public ResponseEntity<SuccessStatusResponse<List<PostFindAllDto>>> findAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(SuccessStatusResponse.of(
                SuccessMessage.POST_FIND_SUCCESS,
                postService.findAllPosts()));
    }




}
