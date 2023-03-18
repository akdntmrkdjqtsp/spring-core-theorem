package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
    
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        
        Member member = new Member(1L, "memberA", Grade.vip);//회원만들고
        memberService.join(member);//저장후
    
        Member findMember = memberService.findMember(1L);//검색해봄
        System.out.println("member = " + member.getName());
        System.out.println("findmember: " + findMember.getName());
    }
}