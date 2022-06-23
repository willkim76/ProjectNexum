package activity;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PromptUserActivity_Factory implements Factory<PromptUserActivity> {
  private static final PromptUserActivity_Factory INSTANCE = new PromptUserActivity_Factory();

  @Override
  public PromptUserActivity get() {
    return new PromptUserActivity();
  }

  public static PromptUserActivity_Factory create() {
    return INSTANCE;
  }
}
