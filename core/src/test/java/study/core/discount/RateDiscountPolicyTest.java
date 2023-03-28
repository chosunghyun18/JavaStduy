package study.core.discount;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.core.member.model.Grade;
import study.core.member.model.Member;


class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip 는 10% 할인이 적용 되어야함")
    void vip_o() {
        Member member = new Member(1L,"memberVip", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip 가 아니면 10% 할인이 적용되면 않됨")
    void vip_x() {
        Member member = new Member(2L,"memberBASIC", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(0);
    }

}