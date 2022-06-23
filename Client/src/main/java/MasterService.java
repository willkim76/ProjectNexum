import models.Client;

public class MasterService {

    public static void main(String[] args) {
        int port = args.length == 0 ? 4848 : Integer.parseInt(args[0]);

        new Client("localhost", port).execute();
    }

}
