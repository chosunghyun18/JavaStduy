package study.core;

import study.core.discount.DiscountPolicy;
import study.core.discount.FixDiscountPolicy;
import study.core.member.repository.MemberRepository;
import study.core.member.repository.MemoryMemberRepository;
import study.core.member.service.MemberService;
import study.core.member.service.MemberServiceImpl;
import study.core.order.service.OrderService;
import study.core.order.service.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
