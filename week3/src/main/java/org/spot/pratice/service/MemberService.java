package org.spot.pratice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spot.pratice.common.exception.NotFoundException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.spot.pratice.service.dto.MemberFindDto;
import org.spot.pratice.domain.Member;
import org.spot.pratice.repository.MemberRepository;
import org.spot.pratice.service.dto.MemberCreateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member createMember(
            MemberCreateDto memberCreate
    ) {
        Member member = Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age());
        return memberRepository.save(member);
    }


    protected Member findMemberById(final Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND));
    }

    public MemberFindDto getMemberById(
            Long memberId
    ) {
        return MemberFindDto.of(findMemberById(memberId));
    }

    @Transactional
    public Member deleteMember(
            Long memberId
    ) {
        Member member = findMemberById(memberId);
        memberRepository.delete(member);
        return member;
    }


    public List<MemberFindDto> getAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream()
                .map(MemberFindDto::of)
                .collect(java.util.stream.Collectors.toList());
    }




}
