package activity;

import dagger.internal.Factory;
import dao.UserDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateNewUserActivity_Factory implements Factory<CreateNewUserActivity> {
  private final Provider<UserDao> userDaoProvider;

  public CreateNewUserActivity_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public CreateNewUserActivity get() {
    return new CreateNewUserActivity(userDaoProvider.get());
  }

  public static CreateNewUserActivity_Factory create(Provider<UserDao> userDaoProvider) {
    return new CreateNewUserActivity_Factory(userDaoProvider);
  }
}
