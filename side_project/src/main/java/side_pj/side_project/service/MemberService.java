package side_pj.side_project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import side_pj.side_project.domain.Member;
import side_pj.side_project.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}

/*package side_pj.side_project.service;

import org.springframework.stereotype.Service;
import side_pj.side_project.domain.Member;
import side_pj.side_project.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    *//* 회원가입 *//*
    public Long join(Member member) {
        //같은 이메일로 중복 회원 x
        validateDuplicateMember(member);
        *//*
        ifPresent : null이 아닌 어떤 값이 있으면 동작. optional로 한번 감싸면 멤버 객체가 존재함.
        tip optional 바로 반환 x
        memberRepository.findByName(member.getName()).
                ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 닉네임입니다"); });
        *//*

    memberRepository.save(member);
    return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByEmail(member.getEmail());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이메일입니다");
        });
    }

    *//* 전체 회원 조회 *//*
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}*/
