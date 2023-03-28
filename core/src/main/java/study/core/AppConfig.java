package study.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.discount.DiscountPolicy;
import study.core.discount.FixDiscountPolicy;
import study.core.discount.RateDiscountPolicy;
import study.core.member.repository.MemberRepository;
import study.core.member.repository.MemoryMemberRepository;
import study.core.member.service.MemberService;
import study.core.member.service.MemberServiceImpl;
import study.core.order.service.OrderService;
import study.core.order.service.OrderServiceImpl;

@Configuration  //Spring 컨테이너에 Bean 이라고 적혀있는 매서드를 등록한다 .
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
