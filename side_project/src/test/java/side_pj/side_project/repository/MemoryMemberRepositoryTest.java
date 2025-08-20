/*
package side_pj.side_project.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import side_pj.side_project.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    JpaMemberRepository repository = new JpaMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    //callback method : 각각의 테스트 끝날 때마다 저장소 삭제
    //테스트 순서가 상관이 없게 됨 (의존관계 없음)

    @Test
    public void save(){
        Member member = new Member();
        member.setName("test1");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("TT");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("EE");
        repository.save(member2);

        Member result = repository.findByName("EE").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("TT");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("EE");
        repository.save(member2);

        //저장된 모든 회원 조회
        List<Member> result = repository.findAll();

        //리스트의 크기가 2인지 검증
        assertThat(result).hasSize(2);
    }

}
*/
