package backend.e_com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import static backend.e_com.entity.type.RoleType.*;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    // ✅ REQUIRED for AuthSer
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    // ✅ SINGLE SecurityFilterChain (merged rules)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                // auth APIs
                .requestMatchers("/public/**","/auth/**").permitAll()

                // API rules
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("/api/students/**").hasAnyRole(ADMIN.name(),STUDENT.name())

                // everything else
                .anyRequest().authenticated()
            ).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .oauth2Login(oAuth2 -> oAuth2
                .successHandler(oAuth2SuccessHandler)
                .failureHandler(
                (request,response,exception)->{
                    log.error("OAuth2 Login Failure: {}", exception.getMessage());
                })
            );

        return http.build();
    }
}
