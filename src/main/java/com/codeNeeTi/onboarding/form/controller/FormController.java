package com.codeNeeTi.onboarding.form.controller;

import com.codeNeeTi.onboarding.dto.ApiResponse;
import com.codeNeeTi.onboarding.form.model.FormConfig;
import com.codeNeeTi.onboarding.form.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/forms")
@RequiredArgsConstructor
public class FormController {

    private final FormService formService;

    /**
     * Returns the form configuration for the given entity type.
     *
     * Example:
     * GET /api/v1/forms/student
     * GET /api/v1/forms/teacher
     * GET /api/v1/forms/employee
     */
    @GetMapping("/{entityType}")
    public ResponseEntity<ApiResponse<FormConfig>> getFormConfiguration(
            @PathVariable String entityType) {
        System.out.println("Inside FormController : " + entityType);
        FormConfig formConfig = formService.getFormConfiguration(entityType);

        return ResponseEntity.ok(
                ApiResponse.<FormConfig>builder()
                        .success(true)
                        .message("Form configuration fetched successfully.")
                        .data(formConfig)
                        .build()
        );
    }
}