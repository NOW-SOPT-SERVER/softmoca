package org.spot.pratice.repository;

import org.spot.pratice.common.exception.NotFoundException;
import org.spot.pratice.common.exception.message.ErrorMessage;
import org.spot.pratice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MemberRepository extends JpaRepository<Member, Long> {


}
