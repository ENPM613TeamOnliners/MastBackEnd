package com.mast.data.dynamodb.repositories;

import com.mast.model.Module;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;

@EnableScan
public interface ModuleRepository extends CrudRepository<Module, String> {
    Module findByModuleId(String moduleId);
    
    List<Module> findByClassId( String classId);
    
    Module findFirstFindByClassIdOrderByCreateDateDesc(String classId);
    
}