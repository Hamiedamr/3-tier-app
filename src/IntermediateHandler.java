import java.io.*;
import java.net.*;
import java.util.Random;

class IntermediateHandler extends Thread {
    final Socket s = null;
    private Socket client;
    private Socket server;
    private static int threadcount = 0;
    private int threadid;

    // Constructor
    public IntermediateHandler(Socket client, Socket server) {
        this.client = client;
        this.server = server;
        threadid = threadcount;
        threadcount++;
    }

    @Override
    public void run() {
        String server_message = null;
        String client_message = null;
        while (true) {
            try {

                client_message = recieveFromClient();
                if (client_message != null)
                    sendToServer(client_message);
                server_message = recieveFromServer();
                if (server_message != null)
                    sendToClient(server_message);

            } catch (IOException e) {
               // e.printStackTrace();
            }
        } //
    }

    private String recieveFromClient() throws IOException {
        // Recieve message from Decison Node
        InputStreamReader inClient = new InputStreamReader(this.client.getInputStream());
        BufferedReader bfClient = new BufferedReader(inClient);
        return bfClient.readLine();
    }

    private void sendToClient(String message) throws IOException {
        // Send message to Decision Node
        PrintWriter prClient = new PrintWriter(this.client.getOutputStream());
        prClient.println(message);
        prClient.flush();
    }

    private String recieveFromServer() throws IOException {
        // Recieve message from Station Node
        InputStreamReader inServer = new InputStreamReader(this.server.getInputStream());
        BufferedReader bfServer = new BufferedReader(inServer);
        return bfServer.readLine();
    }

    private void sendToServer(String message) throws IOException {
        // Send message to Station Node
        PrintWriter prServer = new PrintWriter(this.server.getOutputStream());
        prServer.println(message);
        prServer.flush();
    }
}