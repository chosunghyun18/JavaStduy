package study.core.member.service;

import study.core.member.model.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
