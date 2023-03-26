package study.core.order.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.core.member.model.Grade;
import study.core.member.model.Member;
import study.core.member.service.MemberService;
import study.core.member.service.MemberServiceImpl;
import study.core.order.model.Order;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creteOrder(memberId,"ItemA",1000000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
