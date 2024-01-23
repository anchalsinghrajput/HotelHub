package com.infosys.anchal.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.anchal.UserService.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
