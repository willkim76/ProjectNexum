package dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import models.User;

public class UserDao {
    private DynamoDBMapper dynamoDBMapper;

    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void createUser(User user) {
        dynamoDBMapper.save(user);
    }

    public void editUser(User user) {

    }

}
