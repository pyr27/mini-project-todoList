/*
package side_pj.side_project.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import side_pj.side_project.domain.Member;
import side_pj.side_project.repository.JpaMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    //MemberService memberService = new memberService();
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    //위와 같이 만들면 new 메모리멤버리포지토리에서 새로운 인스턴스가 생기게 되고,
    //MemoryMemberRepository에서 생성한 new 객체와는 또 다른 객체가 만들어지는 것이다.
    //그러면 다른 db가 되므로 아래와 같이 수정해야 한다.
    MemberService memberService;
    JpaMemberRepository memberRepository;
    //내가 직접 new로 인스턴스를 만들어주는 것이 아니고 메모리 멤버 리포지토리를 외부에서 넣어준다.
    //멤버 서비스 입장에서 이런 것을 dependency injection (DI) 라고 한다.

    @BeforeEach
    public void beforeEach() {
        memberRepository = new JpaMemberRepository();
       memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입(){
        //given
        Member member = new Member();
        member.setName("test");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외()  {
        //given
        Member member1 = new Member();
        member1.setEmail("abc@gmail.com");

        Member member2 = new Member();
        member2.setEmail("abc@gmail.com");

        //when
        memberService.join(member1);
        */
/*try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이메일입니다");
        }*//*

        //assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이메일입니다");
    }

    */
/*@Test
    void findOne(){

    }
    @Test
    public void findDuplicate(){
        Member member1 = new Member();
        member1.setEmail("abc@gmail.com");

        Member member2 = new Member();
        member2.setEmail("abc@gmail.com");

    }*//*

}
*/
