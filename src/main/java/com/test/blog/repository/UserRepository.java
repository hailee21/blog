package com.test.blog.repository;

import com.test.blog.entity.UserTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTimeEntity,Integer> {
}
