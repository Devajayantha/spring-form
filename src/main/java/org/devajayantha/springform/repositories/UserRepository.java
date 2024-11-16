package org.devajayantha.springform.repositories;

import org.devajayantha.springform.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
}
