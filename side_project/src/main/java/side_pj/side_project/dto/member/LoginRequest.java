package side_pj.side_project.dto.member;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    private String email;
    private String password;
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}

