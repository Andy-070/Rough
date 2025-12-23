package backend.e_com.security;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import backend.e_com.dto.LoginReqDto;
import backend.e_com.dto.LoginResDto;
import backend.e_com.dto.SignUpDto;
import backend.e_com.dto.SignUpReqDto;
import backend.e_com.entity.Students;
import backend.e_com.entity.User;
import backend.e_com.entity.type.RoleType;
import backend.e_com.entity.type.providerIdType;
import backend.e_com.repo.StudentsRepo;
import backend.e_com.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthSer {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final PasswordEncoder passwordEncoder;
    private final StudentsRepo studentsRepo;

    public LoginResDto login(LoginReqDto loginReqDto) {
        Authentication authen = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginReqDto.getUsername(), 
                loginReqDto.getPassword()
            )
        );
        User user = (User) authen.getPrincipal();

        String accessToken = authUtil.generateaccessToken(user);
        return new LoginResDto(accessToken,user.getId());
    }

    public User signupInternal(SignUpReqDto signUpDto,providerIdType providerType,String providerId) {
        User user = userRepo.findByUsername(signUpDto.getUsername()).orElse(null);
        if (user != null) {
            throw new RuntimeException("Username already exists");
        }
        user =User.builder()
            .username(signUpDto.getUsername())
            .providerId(providerId)
            .providerType(providerType)
            .roles(signUpDto.getRoles())
            .build();

        if(providerType == providerIdType.EMAIL) {
            user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        }


        user = userRepo.save(user);

        Students student = Students.builder()
                .name(signUpDto.getName())
                .email(signUpDto.getUsername())
                .user(user)
                .build();

        studentsRepo.save(student);

        return user;
    }

    public SignUpDto signUp(SignUpReqDto signUpDto) {
        User user = signupInternal(signUpDto, providerIdType.EMAIL, null);
        return new SignUpDto(user.getId(), user.getUsername());
    }

    @Transactional
    public ResponseEntity<LoginResDto> handleOAuth2LoginReq(OAuth2User oAuth2User, String regID) {
        providerIdType providerType = authUtil.getProviderTypeFromRegId(regID);
        String providerId = authUtil.determineProviderIdFromOAuth2User(oAuth2User, regID);

        User user = userRepo.findByProviderIdAndProviderType(providerId, providerType).orElse(null);

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        User emailUser = userRepo.findByUsername(email).orElse(null);
        
        if(user == null && emailUser == null) {
            String username = authUtil.determineUsernameFromOAuth2User(oAuth2User, regID, providerId);
            user = signupInternal(new SignUpReqDto(username, null,name,Set.of(RoleType.STUDENT)), providerType, providerId);
        } else if(user!=null){
            if(email!=null && !email.isBlank() && !email.equals(user.getUsername())){
                user.setUsername(email);
                userRepo.save(user);
            }
        } else{
            throw new RuntimeException("Email already associated with another account");
        }

        LoginResDto loginResDto = new LoginResDto(authUtil.generateaccessToken(user), user.getId());

        return ResponseEntity.ok(loginResDto);
    }

}
