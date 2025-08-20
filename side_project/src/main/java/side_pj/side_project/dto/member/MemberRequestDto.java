package side_pj.side_project.dto.member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public class MemberRequestDto {
    @NotBlank(message = "이름을 입력하십시오")
    private String name;
    @NotBlank(message = "이메일을 입력하십시오")
    @Email(message = "이메일 형식이 올바르지 않습니다")
    private String email;
    @NotBlank(message = "비밀번호를 입력하십시오")
    @Size(min = 6, max = 20, message = "비밀번호는 6자 이상 20자 이하")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,20}$", message = "비밀번호 형식이 올바르지 않습니다. 비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상 포함된 8~20자의 비밀번호여야 합니다")
    private String password;


    public MemberRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
