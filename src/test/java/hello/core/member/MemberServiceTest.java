package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    
    MemberService memberService;
    
    @BeforeEach
    public void before() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        //given
        Member member = new Member(1L, "mamberA", Grade.vip);//회원만들고
        //when
        memberService.join(member);//저장후
        Member findmember = memberService.findMember(1L);//검색해봄
        //then
        Assertions.assertThat(member).isEqualTo(findmember);
        
    }
}
