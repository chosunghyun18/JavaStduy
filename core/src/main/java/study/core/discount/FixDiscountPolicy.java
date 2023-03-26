package study.core.discount;

import study.core.member.model.Grade;
import study.core.member.model.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
