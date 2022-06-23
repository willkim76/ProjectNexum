package dependencies;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DynamoDBModule_DynamoDBMapperProviderFactory implements Factory<DynamoDBMapper> {
  private final DynamoDBModule module;

  public DynamoDBModule_DynamoDBMapperProviderFactory(DynamoDBModule module) {
    this.module = module;
  }

  @Override
  public DynamoDBMapper get() {
    return Preconditions.checkNotNull(
        module.dynamoDBMapperProvider(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static DynamoDBModule_DynamoDBMapperProviderFactory create(DynamoDBModule module) {
    return new DynamoDBModule_DynamoDBMapperProviderFactory(module);
  }

  public static DynamoDBMapper proxyDynamoDBMapperProvider(DynamoDBModule instance) {
    return Preconditions.checkNotNull(
        instance.dynamoDBMapperProvider(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
