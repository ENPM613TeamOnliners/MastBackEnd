package com.mast.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.mast.data.UserType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "ClassObject")
public class ClassObject {
    
    private String classId;
    private Integer semesterYear;
    private String semesterTerm;
    private String courseTitle;
    private String courseType;
    
    
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getClassId() {
        return classId;
    }
    
    @DynamoDBAttribute
    public Integer getSemesterYear() {
        return semesterYear;
    }
    
    @DynamoDBAttribute
    public String getCourseTitle() {
        return courseTitle;
    }
    
    @DynamoDBAttribute
    public String getCourseType() {
        return courseType;
    }
    
    

}
