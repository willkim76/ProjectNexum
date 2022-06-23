package dependencies;

import activity.CreateNewUserActivity;
import activity.UserLoginActivity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dao.UserDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServiceComponents implements ServiceComponents {
  private Provider<DynamoDBMapper> dynamoDBMapperProvider;

  private Provider<UserDao> provideUserDaoProvider;

  private DaggerServiceComponents(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponents create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.dynamoDBMapperProvider =
        DoubleCheck.provider(
            DynamoDBModule_DynamoDBMapperProviderFactory.create(builder.dynamoDBModule));
    this.provideUserDaoProvider =
        DoubleCheck.provider(
            DaoModule_ProvideUserDaoFactory.create(builder.daoModule, dynamoDBMapperProvider));
  }

  @Override
  public CreateNewUserActivity providesCreateNewUserActivityProvider() {
    return new CreateNewUserActivity(provideUserDaoProvider.get());
  }

  @Override
  public UserLoginActivity providesUserLoginActivityProvider() {
    return new UserLoginActivity(provideUserDaoProvider.get());
  }

  public static final class Builder {
    private DynamoDBModule dynamoDBModule;

    private DaoModule daoModule;

    private Builder() {}

    public ServiceComponents build() {
      if (dynamoDBModule == null) {
        this.dynamoDBModule = new DynamoDBModule();
      }
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new DaggerServiceComponents(this);
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }

    public Builder dynamoDBModule(DynamoDBModule dynamoDBModule) {
      this.dynamoDBModule = Preconditions.checkNotNull(dynamoDBModule);
      return this;
    }
  }
}
