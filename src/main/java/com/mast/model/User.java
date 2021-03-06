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
@DynamoDBTable(tableName = "User")
public class User {
    
    private Long userId;
    private String firstName;
    private String accountName;
    private String lastName;
    private String email;
    private String userType;
    
    // public User (Long userId, String firstName, String accountName, String lastName, String email, UserType userType) {
    //     this.userId = userId;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.email = email;
    // }
    
    
    
    @DynamoDBHashKey
    public Long getUserId() {
        return userId;
    }
    @DynamoDBAttribute
    public String getFirstName() {
        return firstName;
    }
    
    @DynamoDBAttribute
    public String getAccountName() {
        return accountName;
    }
    @DynamoDBAttribute
    public String getLastName() {
        return lastName;
    }
    
    @DynamoDBAttribute
    public String getEmail() {
        return email;
    }
    
    @DynamoDBAttribute
    public String getUserType() {
        return userType;
    }
    
    
}
