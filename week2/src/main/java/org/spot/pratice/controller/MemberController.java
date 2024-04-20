package org.spot.pratice.controller;


import lombok.RequiredArgsConstructor;
import org.spot.pratice.domain.Member;
import org.spot.pratice.service.dto.MemberFindDto;
import org.spot.pratice.service.MemberService;
import org.spot.pratice.service.dto.MemberCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> postMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        Member member = memberService.createMember(memberCreate);
        return ResponseEntity.created(URI.create("/members/" + member.getId())).body(member);
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