
package com.codeNeeTi.onboarding.controller;

import com.codeNeeTi.onboarding.dto.ApiResponse;
import com.codeNeeTi.onboarding.dto.RegisterRequest;
import com.codeNeeTi.onboarding.entity.AppUser;
import com.codeNeeTi.onboarding.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AppUser>> register(
            @Valid @RequestBody RegisterRequest req) {

        log.info("User registration request received");

        try {
            AppUser user = userService.register(req);

            log.info("User registered successfully. userId={}", user.getId());

            ApiResponse<AppUser> response = new ApiResponse<>(
                    true,
                    "User registered successfully",
                    user
            );

            return ResponseEntity.ok(response);

        } catch (RuntimeException ex) {

            log.error("User registration failed", ex);

            throw ex;
        }
    }
}
