package dependencies;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dao.UserDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaoModule_ProvideUserDaoFactory implements Factory<UserDao> {
  private final DaoModule module;

  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public DaoModule_ProvideUserDaoFactory(
      DaoModule module, Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.module = module;
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public UserDao get() {
    return Preconditions.checkNotNull(
        module.provideUserDao(dynamoDBMapperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static DaoModule_ProvideUserDaoFactory create(
      DaoModule module, Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new DaoModule_ProvideUserDaoFactory(module, dynamoDBMapperProvider);
  }

  public static UserDao proxyProvideUserDao(DaoModule instance, DynamoDBMapper dynamoDBMapper) {
    return Preconditions.checkNotNull(
        instance.provideUserDao(dynamoDBMapper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
