package activity;

import javax.inject.Inject;

public class PromptUserActivity {

    @Inject
    public PromptUserActivity() {}

    public static void welcomeScreen() {
        System.out.println("Welcome to ProjectMessenger-Client");
    }

}
