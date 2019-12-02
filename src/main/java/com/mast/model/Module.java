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
@DynamoDBTable(tableName = "File")
public class Module {
    
    private Long fileId;
    private Long classId;
    private String fileUrl;
    private String createDate;
    
    @DynamoDBHashKey
    public Long getUserId() {
        return fileId;
    }
    @DynamoDBHashKey
    public Long getClassId() {
        return classId;
    }
    @DynamoDBAttribute
    public String getFirstName() {
        return fileUrl;
    }
    
    @DynamoDBAttribute
    public String getAccountName() {
        return createDate;
    }
    
    

}
