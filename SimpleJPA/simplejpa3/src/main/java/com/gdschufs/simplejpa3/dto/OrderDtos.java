package com.gdschufs.simplejpa3.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

public class OrderDtos {
    @Data
    @NoArgsConstructor
    public static class OrderGetRequest
    {
        private String m_name;
    }

    @Data
    @NoArgsConstructor
    public static class OrderPostRequest
    {
        private Long memberId;
        private Long itemId; // 주문 아이디
        private int count ;

    }

}
