package dependencies;

import dagger.Component;
import activity.CreateNewUserActivity;
import activity.UserLoginActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class, DynamoDBModule.class})
public interface ServiceComponents {

    CreateNewUserActivity providesCreateNewUserActivityProvider();

    UserLoginActivity providesUserLoginActivityProvider();
}
