package side_pj.side_project.dto.member;

public class MemberResponseDto {
    private Long id;
    private String name;
    private String email;

    public MemberResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    // Getter 생략 or 추가
}
