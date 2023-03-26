package study.core.member;


import study.core.member.model.Grade;
import study.core.member.model.Member;
import study.core.member.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
    }
}
