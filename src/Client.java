import java.io.*;
import java.net.*;

public class Client {
    private static Socket server;

    public static void main(String[] args) throws IOException {

        /** Connection Part */

        // Connect to Computing Node
        server = new Socket("localhost", 5000);

        /** Connection Part */

        /** Client Threads */
        Thread client1 = new ServerHandler(server, "WaterStatus");
        Thread client2 = new ServerHandler(server, "SolarStatus");
        Thread client3 = new ServerHandler(server, "WindSatus");
        Thread client4 = new ServerHandler(server, "GasSatus");
        int i = 0;
        while (true) {

            client1.run();
            client2.run();
            client3.run();
            client4.run();
        }
        /** Client Threads */

    }
}