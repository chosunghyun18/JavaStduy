package study.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.member.model.Grade;
import study.core.member.model.Member;
import study.core.member.service.MemberService;
import study.core.member.service.MemberServiceImpl;
import study.core.order.model.Order;
import study.core.order.service.OrderService;
import study.core.order.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creteOrder(memberId,"ItemA",1000000);

        System.out.println("order = "+order); //order.toSting();과 동일
        System.out.println("order calculate Price = "+order.calculatePrice());
        //output :  order = Order{memberId=1, itemName='ItemA', itemPrice=1000000, discountPrice=1000}
    }
}
