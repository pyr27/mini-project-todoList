package side_pj.side_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import side_pj.side_project.config.jwt.JwtTokenProvider;
import side_pj.side_project.domain.Member;
import side_pj.side_project.dto.common.ResponseDto;
import side_pj.side_project.dto.member.LoginResponse;
import side_pj.side_project.dto.member.MemberRequestDto;
import side_pj.side_project.dto.member.MemberResponseDto;
import side_pj.side_project.dto.member.LoginRequest;
import side_pj.side_project.service.MemberService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;
    //private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public MemberController(MemberService memberService, JwtTokenProvider jwtTokenProvider) {
        this.memberService = memberService;
        //this.jwtTokenProvider = jwtTokenProvider;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/join")
    public ResponseDto<String> join(@RequestBody @Valid MemberRequestDto memberReqDto) {
        Member member = new Member();
        member.setName(memberReqDto.getName());
        member.setEmail(memberReqDto.getEmail());
        member.setPassword(memberReqDto.getPassword());

        memberService.join(member);
        return ResponseDto.success("회원가입이 완료되었습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Member> optionalMember = memberService.findByEmail(request.getEmail());

        if(optionalMember.isEmpty()){
            return ResponseEntity
                    .badRequest()
                    .body(ResponseDto.fail(400, "존재하지 않는 이메일입니다."));
        }

        Member member = optionalMember.get();

        if(!member.getPassword().equals(request.getPassword())){
            return ResponseEntity
                    .badRequest()
                    .body(ResponseDto.fail(400, "비밀번호가 일치하지 않습니다."));
        }

        String token = jwtTokenProvider.generateToken(member.getId());

        return ResponseEntity.ok(new LoginResponse(member.getId(), member.getName(), member.getEmail(), token));
    }

    @GetMapping
    public ResponseDto<List<MemberResponseDto>> getMembers() {
        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> result = members.stream()
                .map(member -> new MemberResponseDto(member.getId(), member.getName(), member.getEmail()))
                .toList();

        return ResponseDto.success(result);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ResponseDto<String>> handleIllegalState(IllegalStateException e) {
        return ResponseEntity
                .badRequest()
                .body(ResponseDto.fail(400, e.getMessage()));
    }

    @GetMapping("/me")
    public ResponseEntity<String> me() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) auth.getPrincipal(); // 이메일이 principal로 들어갔다면

        return ResponseEntity.ok("현재 로그인된 사용자: " + email);
    }


}
