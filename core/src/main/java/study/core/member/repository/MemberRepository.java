package study.core.member.repository;

import study.core.member.model.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
