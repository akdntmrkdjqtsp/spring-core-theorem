package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    
    @Test
    @DisplayName("vip는10퍼할인적용되어야한다")
    void vip_o() {
        Member member = new Member(1L, "memberA", Grade.vip);
        int discount = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    
    }
    
    @Test
    @DisplayName("vip아니면할인적용안되어야한다")
    void vip_x() {
        Member member = new Member(2L, "memberB", Grade.basic);
        int discount = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(0);
        
    }
}