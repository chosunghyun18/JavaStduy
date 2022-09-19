package com.gdschufs.simplejpa2.service;

import com.gdschufs.simplejpa2.domain.Order;

import com.gdschufs.simplejpa2.domain.Delivery;
import com.gdschufs.simplejpa2.domain.DeliveryStatus;
import com.gdschufs.simplejpa2.domain.Member;

import com.gdschufs.simplejpa2.repository.MemberRepository;
import com.gdschufs.simplejpa2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository ;



    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId,String o_name ,int count) {

        //엔티티 조회
        Member member = memberRepository.findOne(memberId);


        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setD_address(member.getM_address());
        delivery.setStatus(DeliveryStatus.READY);

        //주문 생성
        Order order = Order.createOrder(member, delivery,o_name);
        //주문 저장
        orderRepository.save(order);

        return order.getId();
    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //주문 취소 -> repository 가 아닌 domain 에서 취소, 취소 != 삭제
        order.cancel();
    }


    public List<Order> findOrderByName(String memberName)
    {
        return orderRepository.findOrderByName(memberName);
    }



}
