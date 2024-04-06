package org.spot.pratice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spot.pratice.service.dto.MemberFindDto;
import org.spot.pratice.domain.Member;
import org.spot.pratice.repository.MemberRepository;
import org.spot.pratice.service.dto.MemberCreateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(
            MemberCreateDto memberCreate
    ) {
        Member member = memberRepository.save(Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age()));
        memberRepository.save(member);
        return member.getId().toString();
    }

    private Member findMemberById(
            Long memberId
    ) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        );
    }

    public MemberFindDto getMemberById(
            Long memberId
    ) {
        return MemberFindDto.of(findMemberById(memberId));
    }

    @Transactional
    public void deleteMember(
            Long memberId
    ) {
        memberRepository.delete(findMemberById(memberId));
    }

}
