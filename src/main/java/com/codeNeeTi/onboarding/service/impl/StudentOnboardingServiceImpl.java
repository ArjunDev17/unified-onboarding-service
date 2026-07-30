package com.codeNeeTi.onboarding.service.impl;

import com.codeNeeTi.onboarding.dto.StudentRegistrationRequest;
import com.codeNeeTi.onboarding.entity.Student;
import com.codeNeeTi.onboarding.repository.StudentRepository;
import com.codeNeeTi.onboarding.service.StudentOnboardingService;
import com.codeNeeTi.onboarding.dto.StudentRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
@RequiredArgsConstructor
public class StudentOnboardingServiceImpl implements StudentOnboardingService {

    private final StudentRepository studentRepository;

    @Override
    public StudentRegistrationResponse registerStudent(StudentRegistrationRequest request) {

        validateStudent(request);

        Student student = mapToEntity(request);

        student.setRegistrationNumber(generateRegistrationNumber());

        Student savedStudent = studentRepository.save(student);

        return StudentRegistrationResponse.builder()
                .studentId(savedStudent.getId())
                .registrationNumber(savedStudent.getRegistrationNumber())
                .status(savedStudent.getStatus())
                .build();
    }

    /**
     * Validate duplicate student.
     */
    private void validateStudent(StudentRegistrationRequest request) {

        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already registered.");
        }

        if (studentRepository.existsByMobile(request.getMobile())) {
            throw new IllegalArgumentException("Mobile number already registered.");
        }

        if (request.getAadhaarNumber() != null
                && !request.getAadhaarNumber().isBlank()
                && studentRepository.existsByAadhaarNumber(request.getAadhaarNumber())) {

            throw new IllegalArgumentException("Aadhaar already registered.");
        }
    }

    /**
     * Convert Request DTO to Entity.
     */
    private Student mapToEntity(StudentRegistrationRequest request) {

        return Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .course(request.getCourse())
                .semester(request.getSemester())
                .fatherName(request.getFatherName())
                .motherName(request.getMotherName())
                .address(request.getAddress())
                .city(request.getCity())
//                .district(request.getDistrict())
                .state(request.getState())
//                .country(request.getCountry())
//                .pinCode(request.getPinCode())
                .bloodGroup(request.getBloodGroup())
                .aadhaarNumber(request.getAadhaarNumber())
                .emergencyContact(request.getEmergencyContact())
                .photoUrl(request.getPhoto())
                .status("REGISTERED")
                .build();
    }

    /**
     * Generate registration number.
     * Example: STU-2026-123456789
     */
    private String generateRegistrationNumber() {

        return "STU-"
                + Year.now().getValue()
                + "-"
                + System.currentTimeMillis();
    }
}