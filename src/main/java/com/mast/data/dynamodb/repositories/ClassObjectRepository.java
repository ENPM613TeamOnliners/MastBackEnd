package com.mast.data.dynamodb.repositories;

import com.mast.model.ClassObject;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;

@EnableScan
public interface ClassObjectRepository extends CrudRepository<ClassObject, String> {
    ClassObject findByClassId(String id);
    
}