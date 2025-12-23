package backend.e_com.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import backend.e_com.entity.User;
import backend.e_com.entity.type.providerIdType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthUtil {

    @Value("${jwt.secretKey}")
    private String secretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateaccessToken(User user) {
        return Jwts.builder()
            .subject(user.getUsername())
            .claim("userId", user.getId().toString())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 10000*60))
            .signWith(getSecretKey())
            .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
        .verifyWith(getSecretKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();

        return claims.getSubject();
    }


    public providerIdType getProviderTypeFromRegId(String regId) {
        switch (regId.toLowerCase()) {
            case "google":
                return providerIdType.GOOGLE;
            case "facebook":
                return providerIdType.FACEBOOK;
            case "github":
                return providerIdType.GITHUB;
            case "twitter":
                return providerIdType.TWITTER;
            default:
                return providerIdType.EMAIL;
        }
    }

    public String determineProviderIdFromOAuth2User(OAuth2User oAuth2User, String regId) {
        String providerId = switch(regId.toLowerCase()) {
            case "google" -> oAuth2User.getAttribute("sub");
            case "facebook" -> oAuth2User.getAttribute("id");
            case "github" -> oAuth2User.getAttribute("id").toString();
            case "twitter" -> oAuth2User.getAttribute("id_str");
            default -> null;
        };

        if(providerId == null || providerId.isEmpty()) {
            throw new RuntimeException("Unsupported OAuth2 provider or missing provider ID");
        }
        return providerId;
    }

    public String determineUsernameFromOAuth2User(OAuth2User oAuth2User,String regId,String providerId) {
        String email = oAuth2User.getAttribute("email");
        if(email != null && !email.isEmpty()) {
            return email;
        } 
        return switch(regId.toLowerCase()) {
            case "google" -> oAuth2User.getAttribute("sub");
            case "facebook" -> oAuth2User.getAttribute("name");
            case "github" -> oAuth2User.getAttribute("login");
            case "twitter" -> oAuth2User.getAttribute("screen_name");
            default -> "user_" + providerId;
        };
    }
}
