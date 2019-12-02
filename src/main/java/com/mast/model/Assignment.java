package com.mast.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Assignment")
public class Assignment {
    
    private String assignmentId;
    private String studentId;
    private String assignmentTitle;
    private String assignmentContent;
    private Double grade;
    private Long fileId;
    private Long classId;
    
    // public User (Long userId, String firstName, String accountName, String lastName, String email, UserType userType) {
    //     this.userId = userId;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.email = email;
    // }
    
    
    
    @DynamoDBHashKey
    public String getAssignmentId() {
        return assignmentId;
    }
    
    @DynamoDBAttribute
    public String getStudentId() {
        return studentId;
    }
    
    
    @DynamoDBAttribute
    public String getAssignmentContent() {
        return assignmentContent;
    }
    
    @DynamoDBAttribute
    public Double getGrade() {
        return grade;
    }
    @DynamoDBAttribute
    public Long getFileId() {
        return fileId;
    }
    
    @DynamoDBAttribute
    public Long getClassId() {
        return classId;
    }
    
    @DynamoDBAttribute
    public String getAssignmentTitle() {
        return assignmentTitle;
    }
    
    
}
