package side_pj.side_project.config.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private final Key key;
    private final long expiration = 1000 * 60 * 60 * 24; // 24시간

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // 토큰 생성
    public String generateToken(Long userId) {
        return Jwts.builder()
                //.subject(email)
                .claim("userId", userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(key).build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 사용자 ID 추출
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(key).build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.get("userId", String.class);
    }

    public Authentication getAuthentication(String token) {
        String email = getUserIdFromToken(token);
        return new UsernamePasswordAuthenticationToken(
                email,                // principal (보통 사용자 ID, email 등)
                null,                 // credentials (보통 null로 처리)
                List.of(new SimpleGrantedAuthority("ROLE_USER")) // 권한 추가도 가능
        );
    }


    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(key).build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
