package sopkathon.mobile3.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopkathon.mobile3.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}