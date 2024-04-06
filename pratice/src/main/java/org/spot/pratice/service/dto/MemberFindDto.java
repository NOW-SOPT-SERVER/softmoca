package org.spot.pratice.service.dto;

import org.spot.pratice.domain.Member;
import org.spot.pratice.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {

    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
