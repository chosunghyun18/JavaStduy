package study.core;

import study.core.member.model.Grade;
import study.core.member.model.Member;
import study.core.member.service.MemberService;
import study.core.member.service.MemberServiceImpl;
import study.core.order.model.Order;
import study.core.order.service.OrderService;
import study.core.order.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creteOrder(1L,"ItemA",1000000);

        System.out.println("order = "+order); //order.toSting();과 동일
        System.out.println("order calculate Price = "+order.calculatePrice());
        //output :  order = Order{memberId=1, itemName='ItemA', itemPrice=1000000, discountPrice=1000}
    }
}
