package com.gdschufs.simplejpa2.api;


import com.gdschufs.simplejpa2.domain.Order;
import com.gdschufs.simplejpa2.dto.ResultDtos.*;
import com.gdschufs.simplejpa2.service.MemberService;
import com.gdschufs.simplejpa2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import com.gdschufs.simplejpa2.dto.OrderDtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;
    private final MemberService memberService;

    @PostMapping(value="/api/order" , produces = "application/json;charset=UTF-8")
    public ResultResponseMessage order(@RequestBody OrderPostRequest request)
    {
        if(memberService.findOne(request.getMemberId()) != null){
            orderService.order(request.getMemberId(),request.getO_name(),request.getCount());
            return new ResultResponseMessage("post Complete", 200);
        }
        else {
            return new ResultResponseMessage("Wrong member id", 400);
        }
    }

    @GetMapping(value="/api/orders" , produces = "application/json;charset=UTF-8")
    public ResultResponseData orderList(@RequestBody OrderGetRequest request)
    {
        List<Order> orders = orderService.findOrderByName(request.getM_name());
        return  new ResultResponseData("this is results", 200 ,orders);
    }

//    @PostMapping("/orders/{orderId}/cancel")
//    public ResultResponseMessage cancelOrder(@PathVariable("orderId") Long orderId) {
//        orderService.cancelOrder(orderId);
//        return  new ResultResponseMessage("Post Complete cancel order" , 200 );
//    }
    @PostMapping("/orders/cancel")
    public ResultResponseMessage cancelOrder(@RequestParam("orderId") Long orderId)
    {
        orderService.cancelOrder(orderId);
        return  new ResultResponseMessage(" Cancel Order" , 200 );
    }




}
