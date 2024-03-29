package dependencies;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;
import dao.UserDao;

import javax.inject.Singleton;

@Module
public class DaoModule {

    @Singleton
    @Provides
    UserDao provideUserDao(DynamoDBMapper dynamoDBMapper) {
        return new UserDao(dynamoDBMapper);
    }
}
