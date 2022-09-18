package com.gdschufs.simplejpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order
{
    @Id
    @GeneratedValue
    @Column(name = "o_id")
    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "m_id")
    private Member member;

    @JsonIgnore
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "d_id")
    private Delivery delivery;

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]


    //==연관관계 메서드==//

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //==생성 메서드==//  Domain Model  pattern : https://blog.naver.com/PostView.nhn?blogId=good_ray&logNo=222267722516

    public static Order createOrder(Member member, Delivery delivery) //*, OrderItem... orderItems*// )
    {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
//        for (OrderItem orderItem : orderItems) {
//            order.addOrderItem(orderItem);
//        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    //==비즈니스 로직==//



}
