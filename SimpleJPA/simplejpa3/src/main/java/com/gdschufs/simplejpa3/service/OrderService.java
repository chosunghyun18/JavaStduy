package com.gdschufs.simplejpa3.service;

import com.gdschufs.simplejpa3.domain.*;

import com.gdschufs.simplejpa3.domain.item.Item;
import com.gdschufs.simplejpa3.repository.ItemRepository;
import com.gdschufs.simplejpa3.repository.MemberRepository;
import com.gdschufs.simplejpa3.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository ;
    private final ItemRepository itemRepository;

//
    /**
     *
     * @param memberId
     * @param itemId
     * @param count
     * @return order Id longtype
     */
    @Transactional
    public Long order(Long memberId,Long itemId, int count)
    {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setD_address(member.getM_address());
        delivery.setStatus(DeliveryStatus.READY);
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery,orderItem);

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


    public List<Order> findOrdersByName(String memberName)
    {
        return orderRepository.findOrdersByName(memberName);
    }

    public List<Order> findOrdersByCriteria(String memberName)
    {
        return  orderRepository.findAllByCriteria(memberName);
    }

}
