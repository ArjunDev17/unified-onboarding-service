package com.codeNeeTi.onboarding.controller;

import com.codeNeeTi.onboarding.dto.ApiResponse;
import com.codeNeeTi.onboarding.dto.StudentRegistrationRequest;
import com.codeNeeTi.onboarding.dto.StudentRegistrationResponse;
import com.codeNeeTi.onboarding.service.StudentOnboardingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/onboarding/student")
@RequiredArgsConstructor
public class StudentOnboardingController {

    private final StudentOnboardingService studentOnboardingService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<StudentRegistrationResponse>> registerStudent(
            @Valid @RequestBody StudentRegistrationRequest request) {

        System.out.println("Student registration request received");

        StudentRegistrationResponse response =
                studentOnboardingService.registerStudent(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<StudentRegistrationResponse>builder()
                        .success(true)
                        .message("Student registered successfully.")
                        .data(response)
                        .build());
    }
}