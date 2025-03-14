package org.example.testingp.repo;

import org.example.testingp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
