package com.codeNeeTi.onboarding.service;

import com.codeNeeTi.onboarding.dto.StudentRegistrationRequest;
import com.codeNeeTi.onboarding.dto.StudentRegistrationResponse;

public interface StudentOnboardingService {

    /**
     * Registers a new student.
     *
     * @param request Student registration request
     * @return Student registration response
     */
    StudentRegistrationResponse registerStudent(StudentRegistrationRequest request);

}