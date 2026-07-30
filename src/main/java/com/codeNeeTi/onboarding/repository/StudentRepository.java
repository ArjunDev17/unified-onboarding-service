
package com.codeNeeTi.onboarding.repository;

import com.codeNeeTi.onboarding.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    Optional<Student> findByMobile(String mobile);

    Optional<Student> findByRegistrationNumber(String registrationNumber);

    boolean existsByEmail(String email);

    boolean existsByMobile(String mobile);

    boolean existsByAadhaarNumber(String aadhaarNumber);
}
