package study.core.member.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.core.member.model.Grade;
import study.core.member.model.Member;


public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void JOin(){

        Member member = new Member(1L,"memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
