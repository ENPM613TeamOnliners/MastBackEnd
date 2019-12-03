package com.mast.data.dynamodb.repositories;

import com.mast.model.Assignment;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;
//   private Long announcementId;
//     private Long classId;
//     private String messageBody;
//     private Long messageSenderId;
//     private String dateSent;
@EnableScan
public interface AssignmentRepository extends CrudRepository<Assignment, String> {
    Assignment findByAssignmentId(String id);
    
    List<Assignment> findByClassId(String classId);
    
    List<Assignment> findByStudentIdAndClassId(String studentId, String classId);
    
    // List<User> findByLastName(String lastName);
}