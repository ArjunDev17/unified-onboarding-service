package com.codeNeeTi.onboarding.repository;

import com.codeNeeTi.onboarding.entity.AppUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repository for AppUser entity. */
public interface UserRepository extends JpaRepository<AppUser, Long> {
  Optional<AppUser> findByUsername(String username);

  Optional<AppUser> findByEmail(String email);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);
}
