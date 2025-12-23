package backend.e_com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.e_com.dto.LoginReqDto;
import backend.e_com.dto.LoginResDto;
import backend.e_com.dto.SignUpReqDto;
import backend.e_com.dto.SignUpDto;
import backend.e_com.security.AuthSer;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCon {

    private final AuthSer authSer;

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> login(@RequestBody LoginReqDto loginReqDto){ 
        return ResponseEntity.ok(authSer.login(loginReqDto));
    }
    
    @PostMapping("/signup")
    public ResponseEntity<SignUpDto> signUp(@RequestBody SignUpReqDto signUpDto) {
        return ResponseEntity.ok(authSer.signUp(signUpDto));
    }
    

}
