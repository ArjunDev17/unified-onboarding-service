
package com.codeNeeTi.onboarding.controller;

import com.codeNeeTi.onboarding.dto.AuthResponse;
import com.codeNeeTi.onboarding.dto.LoginRequest;
import com.codeNeeTi.onboarding.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        log.info("Login request received for username={}", request.username);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username,
                            request.password
                    )
            );

            log.info("User authentication successful for username={}",
                    request.username);

            String token = jwtUtil.generateToken(request.username);

            log.debug("JWT token generated successfully for username={}",
                    request.username);

            AuthResponse response = new AuthResponse(token, "Bearer");

            log.info("Login completed successfully for username={}",
                    request.username);

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException ex) {

            log.warn("Authentication failed for username={}: invalid credentials",
                    request.username);

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid username or password"
            );

        } catch (Exception ex) {

            log.error("Unexpected error during login for username={}",
                    request.username, ex);

            throw ex;
        }
    }
}
