package study.core.order.service;

import study.core.order.model.Order;

public interface OrderService {
    Order creteOrder(Long memberId,String itemName,int itemPrice);
}
