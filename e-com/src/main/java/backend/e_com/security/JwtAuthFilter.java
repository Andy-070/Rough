package backend.e_com.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import backend.e_com.entity.User;
import backend.e_com.repo.UserRepo;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter{

    private final UserRepo userRepo;
    private final AuthUtil authUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
        try {
            log.info("incoming request: {} {}", request.getMethod(), request.getRequestURI());

                final String authHeader = request.getHeader("Authorization");
                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    filterChain.doFilter(request, response);
                    return;
                }

                String jwt = authHeader.split("Bearer")[1];
                String username = authUtil.getUsernameFromToken(jwt);

                if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    User user = userRepo.findByUsername(username).orElse(null);
                    if(user != null) {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            user.getAuthorities()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                    filterChain.doFilter(request, response);
                
                }

        }catch (Exception e) {
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }        
}
