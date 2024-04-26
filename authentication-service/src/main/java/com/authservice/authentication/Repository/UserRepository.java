package com.authservice.authentication.Repository;

import com.authservice.authentication.model.UserL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserL, Long> {

}
