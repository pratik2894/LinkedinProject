package com.services.userService.repository;

import com.services.userService.Entities.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<userModel, UUID> {

   boolean existsByEmail(String email);
   boolean existsByUserId(UUID userId);

   @Query("SELECT u from userModel u where u.userId = :userId")
   Optional<userModel> findUserById( @Param("userId") UUID userId);
}
