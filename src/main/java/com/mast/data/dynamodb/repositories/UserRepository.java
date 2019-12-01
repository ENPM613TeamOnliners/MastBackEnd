package com.mast.data.dynamodb.repositories;

import com.mast.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;

@EnableScan
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserId(Long id);
    
    // List<User> findByLastName(String lastName);
}