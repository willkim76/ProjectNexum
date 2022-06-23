
import com.amazonaws.services.dynamodbv2.xspec.S;
import dependencies.DaggerServiceComponents;
import dependencies.ServiceComponents;
import models.Server;

import java.io.IOException;
import java.util.Set;

public class MasterService {
    private ServiceComponents components = DaggerServiceComponents.create();
    private Set<Server> servers;

    public static void main(String[] args) {

        try {
            new Server().execute();
        } catch (IOException e) {
            System.out.println("Exception has occurred: " + e.getMessage());
        }

    }
}
