package com.mast.data.dynamodb.repositories;

import com.mast.model.Announcement;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;

@EnableScan
public interface AnnouncementRepository extends CrudRepository<Announcement, String> {
  
    Announcement findByAnnouncementId(String id);
    
    List<Announcement> findByClassId(String classId);
    
    Announcement findFirstFindByClassIdOrderByDateSentDesc(String classId);
    
    // List<User> findByLastName(String lastName);
}