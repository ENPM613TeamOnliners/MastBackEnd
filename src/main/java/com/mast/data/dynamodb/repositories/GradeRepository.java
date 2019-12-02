package com.mast.data.dynamodb.repositories;

import com.mast.model.Grade;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;

@EnableScan
public interface GradeRepository extends CrudRepository<Grade, String> {
    Grade findByGradeId(String id);
    
    List<Grade> findByStudentIdAndClassId(String studentId, String classId);
    
    Grade findByStudentIdAndAssignmentId(String studentId, String assignmentId);
    
    // List<User> findByLastName(String lastName);
}