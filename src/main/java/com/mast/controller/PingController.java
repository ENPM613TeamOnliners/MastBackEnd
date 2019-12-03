package com.mast.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import com.mast.model.User;
import com.mast.model.Grade;
import com.mast.model.Module;
import com.mast.model.ClassObject;
import java.util.Map;
import java.util.List;
import com.mast.data.dynamodb.repositories.UserRepository;
import com.mast.data.dynamodb.repositories.GradeRepository;
import com.mast.data.dynamodb.repositories.AssignmentRepository;
import com.mast.data.dynamodb.repositories.ClassObjectRepository;
import com.mast.data.dynamodb.repositories.ModuleRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@EnableWebMvc
public class PingController {
    
    
    @Autowired
    UserRepository repository;
    
    @Autowired
    ClassObjectRepository classRepository;
    
    @Autowired
    GradeRepository gradeRepository;
    
    @Autowired
    ModuleRepository moduleRepository;
    
    @Autowired
    AssignmentRepository assignmentRepository;
    
    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public Map<String, String> ping() {
        Map<String, String> pong = new HashMap<>();
        pong.put("pong", "Hello, World!");
        return pong;
    }
    
    @GetMapping(path = "/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUser(@PathVariable("userId") Long userId) {
        User result = repository.findByUserId(userId);
        
        return result;
    }
    @GetMapping(path = "/users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<User> getUsers() {
        List<User> result = (List<User>) repository.findAll();
        
        return result;
    }

    @PostMapping(path = "/createClass")
    @ResponseStatus(HttpStatus.OK)
    public void createClass(@RequestBody  ClassObject clazz) {
        
        classRepository.save(clazz);
    }
    
    @PostMapping(path = "/setGrade")
    @ResponseStatus(HttpStatus.OK)
    public void setGrade(@RequestBody Grade grade) {
       gradeRepository.save(grade);
    }
    
    @GetMapping(path = "/viewStudentGrades/{studentId}/class/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Grade> getClassGrade(@PathVariable("studentId") String studentId, @PathVariable("classId") String classId) {
      List<Grade> results = (List<Grade>) gradeRepository.findByStudentIdAndClassId(studentId,classId);
      
      return results;
    }  
    
    @GetMapping(path = "/viewStudentGrades/{studentId}/assignment/{assignmentId}")
    @ResponseStatus(HttpStatus.OK)
    public Grade getAssignmentGrade(@PathVariable("studentId") String studentId, @PathVariable("assignmentId") String assignmentId) {
      Grade result = gradeRepository.findByStudentIdAndAssignmentId(studentId,assignmentId);
      
      return result;
    }
    
    @GetMapping(path = "/getLastModule/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public Module getLastModule(@PathVariable("classId") String classId) {
      Module result = moduleRepository.findFirstFindByClassIdOrderByCreateDateDesc(classId);
      
      return result;
    }
    
    @GetMapping(path = "/getModules/{classId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Module> getAllModules(@PathVariable("classId") String classId) {
      List<Module> result = (List<Module>) moduleRepository.findByClassId(classId);
      
      return result;
    }
    
    @PostMapping(path = "/addModule")
    @ResponseStatus(HttpStatus.OK)
    public void addModule(@RequestBody Module module) {
       moduleRepository.save(module);
    }
    
}
