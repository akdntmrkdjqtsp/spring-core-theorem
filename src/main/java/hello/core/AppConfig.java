package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {//멤버서비스에서 멤버리포지토리쓸거다
        return new MemberServiceImpl(memberRepository());
    }
    
    private MemberRepository memberRepository() {//멤버리포지토리는 메모리쓸거다
        return new MemoryMemberRepository();
    }
    
    public OrderService orderService() {//오더서비스에서 멤버리포지토리랑 할인정책쓸거다
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    
    private DiscountPolicy discountPolicy() {//할인정책은 정잭제다
        return new FixDiscountPolicy();
    }
}
