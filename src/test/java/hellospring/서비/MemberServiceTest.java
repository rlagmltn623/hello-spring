package hellospring.서비;

import hellospring.도메인.Member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    public static void main(String[] args) {
        System.out.println("테스트");
    }
    @Test
    void 회원가입() {
        //GIVEN
        Member member = new Member();
        member.setName("hello");
        //WHEN
        Long saveId = memberService.join(member);

        //THEN
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
        }

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}