package activity;

import dagger.internal.Factory;
import dao.UserDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserLoginActivity_Factory implements Factory<UserLoginActivity> {
  private final Provider<UserDao> userDaoProvider;

  public UserLoginActivity_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public UserLoginActivity get() {
    return new UserLoginActivity(userDaoProvider.get());
  }

  public static UserLoginActivity_Factory create(Provider<UserDao> userDaoProvider) {
    return new UserLoginActivity_Factory(userDaoProvider);
  }
}
