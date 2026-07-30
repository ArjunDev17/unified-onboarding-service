package com.codeNeeTi.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistrationResponse {

    /**
     * Database generated primary key.
     */
    private Long studentId;

    /**
     * Business registration number.
     * Example: STU-2026-1722212345678
     */
    private String registrationNumber;

    /**
     * Registration status.
     * Example: REGISTERED
     */
    private String status;
}
