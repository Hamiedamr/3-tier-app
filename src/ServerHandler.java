import java.io.*;
import java.net.*;
import java.util.Random;

class ServerHandler extends Thread {
    final Socket s = null;

    private Socket server;
    private static int threadcount = 0;
    private int threadid;
    private String message;

    // Constructor
    public ServerHandler(Socket s, String message) {
        this.server = s;
        this.message = message;
        threadid = threadcount;
        threadcount++;
    }

    @Override
    public void run() {

        try {
            messageToServer(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void messageToServer(String messageToServer) throws IOException {
        // Todo
        /**
         * Send message to computing node at port 5000 Recieve messafe from computing
         * node at port 5000 Compare the received water level with threshold value and
         * send decisison at port 5001
         */
        System.out.println("client no: " + (threadid+1) + " sends " + messageToServer);
        String msg = "";
        try {
            sendToServer(messageToServer);
            msg = recieveFromServer();
            Float level = Float.parseFloat(msg);
            if (level > 5.5f) {
                System.out.println(messageToServer + " = " + level);
                if (messageToServer.contains("Water")) {
                    sendToServer("close the gates");
                } else if (messageToServer.contains("Solar")) {
                    sendToServer("rotate the cells cw 45");
                } else if (messageToServer.contains("Wind")) {
                    sendToServer("rotate the stator cw 45");
                } else if (messageToServer.contains("Gas")) {
                    sendToServer("close the valve");
                }
            } else if (level <= 5.5f) {
                if (messageToServer.contains("Water")) {
                    sendToServer("open the gates");
                } else if (messageToServer.contains("Solar")) {
                    sendToServer("rotate the cells ccw 45");
                } else if (messageToServer.contains("Wind")) {
                    sendToServer("rotate the stator ccw 45");
                } else if (messageToServer.contains("Gas")) {
                    sendToServer("open the valve");
                } 
                   
                
            }
        } catch (NumberFormatException e) {
            System.out.println(msg);
        }
        

    }

    private String recieveFromServer() throws IOException {
        // Recieve message from Computing Node
        InputStreamReader inServer = new InputStreamReader(this.server.getInputStream());
        BufferedReader bfServer = new BufferedReader(inServer);
        return bfServer.readLine();
    }

    private void sendToServer(String message) throws IOException {
        // Send message to Computing Node
        PrintWriter prServer = new PrintWriter(this.server.getOutputStream());
        prServer.println(message);
        prServer.flush();
    }
}