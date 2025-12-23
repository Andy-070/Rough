package backend.e_com.security;

import java.io.IOException;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import backend.e_com.dto.LoginResDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final AuthSer authSer;
    private final ObjectMapper objectMapper;

    public OAuth2SuccessHandler(
            @Lazy AuthSer authSer,
            ObjectMapper objectMapper
    ) {
        this.authSer = authSer;
        this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        OAuth2AuthenticationToken authToken =
                (OAuth2AuthenticationToken) authentication;

        OAuth2User oAuth2User =
                (OAuth2User) authentication.getPrincipal();

        String regId =
                authToken.getAuthorizedClientRegistrationId();

        ResponseEntity<LoginResDto> loginResponse =
                authSer.handleOAuth2LoginReq(oAuth2User, regId);

        response.setStatus(loginResponse.getStatusCode().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter()
                .write(new ObjectMapper().writeValueAsString(loginResponse.getBody()));
    }
}
