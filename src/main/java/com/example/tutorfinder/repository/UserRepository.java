package com.example.tutorfinder.repository;

import com.example.tutorfinder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
