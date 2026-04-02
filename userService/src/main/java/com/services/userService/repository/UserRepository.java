package com.services.userService.repository;

import com.services.userService.Entities.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<userModel, UUID> {

   boolean existsByEmail(String email);

}
