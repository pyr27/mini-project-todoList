package side_pj.side_project.controller;

//import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import side_pj.side_project.config.jwt.JwtTokenProvider;

@RestController
@RequestMapping("/api/jwt")
//@RequiredArgsConstructor
public class JwtTestController {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtTestController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // 1️⃣ 토큰 생성 API
    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestParam Long userId) {
        String token = jwtTokenProvider.generateToken(userId);
        return ResponseEntity.ok(token);
    }

    // 2️⃣ 토큰에서 userId 추출 API
    @GetMapping("/userid")
    public ResponseEntity<String> extractUserId(@RequestHeader("Authorization") String bearerToken) {
        // "Bearer eyJ..." → "eyJ..."
        String token = bearerToken.replace("Bearer ", "");
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        return ResponseEntity.ok(userId);
    }
}