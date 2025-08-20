package side_pj.side_project.dto.member;

public class LoginResponse {
    private Long id;
    private String name;
    private String email;
    private String token; // JWT 토큰이 있다면 포함

    public LoginResponse(Long id, String name, String email, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
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
    public String getToken() {
        return token;
    }
}
