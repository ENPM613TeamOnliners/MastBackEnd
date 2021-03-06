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
@DynamoDBTable(tableName = "File")
public class Announcement {
    
    private String announcementId;
    private String classId;
    private String messageBody;
    private String messageSenderId;
    private String dateSent;
    
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getAnnouncementId() {
        return announcementId;
    }

    @DynamoDBAttribute
    public String getClassId() {
        return classId;
    }
    @DynamoDBAttribute
    public String getMessageBody() {
        return messageBody;
    }
    @DynamoDBAttribute
    public String getMessageSenderId() {
        return messageSenderId;
    }
    
    @DynamoDBAttribute
    public String getDateSent() {
        return dateSent;
    }
    
    

}
