package com.mystore.auth.service;

import com.mystore.auth.dto.LoginRequest;
import com.mystore.auth.dto.TokenResponse;
import com.mystore.auth.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse login(LoginRequest request) {
        // TODO: DB에서 유저 조회 후 비밀번호 검증
        // 임시 구현
        String token = jwtUtil.generateToken(request.getUsername());
        return new TokenResponse(token);
    }

    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
}
