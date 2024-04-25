package com.authservice.authentication.Repository;

import com.authservice.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Long> {

}
