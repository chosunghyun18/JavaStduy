package study.core.order.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.AppConfig;
import study.core.member.model.Grade;
import study.core.member.model.Member;
import study.core.member.service.MemberService;
import study.core.member.service.MemberServiceImpl;
import study.core.order.model.Order;

public class OrderServiceTest {

    MemberService memberService ;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creteOrder(memberId,"ItemA",1000000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
