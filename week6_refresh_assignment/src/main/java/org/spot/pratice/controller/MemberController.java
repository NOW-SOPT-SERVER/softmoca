package org.spot.pratice.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.spot.pratice.auth.PrincipalHandler;
import org.spot.pratice.common.exception.UnauthorizedException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.spot.pratice.domain.Member;
import org.spot.pratice.service.dto.MemberFindDto;
import org.spot.pratice.service.MemberService;
import org.spot.pratice.service.dto.MemberCreateDto;
import org.spot.pratice.service.dto.UserJoinResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;
    private final PrincipalHandler principalHandler;

    @PostMapping
    public ResponseEntity<UserJoinResponse> postMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }

    @GetMapping("/refresh")
    public ResponseEntity<UserJoinResponse> refreshToken(@RequestHeader("Authorization") String refreshToken){

        refreshToken = refreshToken.substring(7); // "Bearer " 부분을 제거


        UserJoinResponse userJoinResponse = memberService.refreshToken(refreshToken);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userJoinResponse);
    }



    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> getMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.getMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Member> deleteMember(
            @PathVariable Long memberId
    ) {
        Member member = memberService.deleteMember(memberId);
        return ResponseEntity.ok(member);
    }


    @GetMapping
    public ResponseEntity<List<MemberFindDto>> getAllMembers() {
        List<MemberFindDto> memberList = memberService.getAllMembers();
        return ResponseEntity.ok(memberList);
    }

}