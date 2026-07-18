package com.codeNeeTi.onboarding.controller;

import com.codeNeeTi.onboarding.dto.AuthResponse;
import com.codeNeeTi.onboarding.dto.LoginRequest;
import com.codeNeeTi.onboarding.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;

  public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {

    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request.username, request.password));

      String token = jwtUtil.generateToken(request.username);

      AuthResponse response = new AuthResponse(token, "Bearer");

      return ResponseEntity.ok(response);

    } catch (BadCredentialsException ex) {
      throw new org.springframework.web.server.ResponseStatusException(
          HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
  }
}
