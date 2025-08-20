/*package side_pj.side_project.repository;

import org.springframework.stereotype.JpaRepository;
import org.springframework.stereotype.Repository;
import side_pj.side_project.domain.Member;

import java.util.*;

import java.util.Optional;

@Repository
public class JpaMemberRepository implements JpaRepository<Member, Long> {

    private static Map<Long, Member> store = new HashMap<>();
    //동시성 문제가 있을 수 있어 공유되는 변수 hashmap 사용
    private static long sequence = 0L;
    //실무에서는 long보다는 atomic long 해야함
    @Override
    public void save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        //아이디 세팅 -> 스토어 저장 -> map 저장
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                    .filter(member -> member.getName().equals(name))
                    .findAny();
        //멤버에서 member.getName이 여기 파라미터로 넘어온 name이랑 equals한지 확인
        //같은 경우에만 필터링되고 그 중에서 찾으면 반환함

    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //스토어에 있는 values가 멤버들이고 이 멤버들을 반환
    }

    public void clearStore() {
        store.clear();
    }

    //public interface TodoRepository extends JpaRepository<Todo, Long>
}*/
