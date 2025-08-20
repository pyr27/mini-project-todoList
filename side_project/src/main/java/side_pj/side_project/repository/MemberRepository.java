package side_pj.side_project.repository;

import org.springframework.stereotype.Repository;
import side_pj.side_project.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //Object save(Member member);
    //회원 저장소에 저장 & find로 id/name 찾아올 수 있음
    //Optional<Member> findById(Long id);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);
    Optional<Member> findByEmail(String email);
    //null 반환 대신 optional로 감싸 반환하는 방법 많이 선호
    List<Member> findAll(); //지금까지 저장된 모든 회원리스트 반환

}
