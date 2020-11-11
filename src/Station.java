import java.io.*;
import java.net.*;

public class Station {
    private static Socket computing;
    public static void main(String[] args) throws IOException{
        //Conncect to Computing and Accept
        ServerSocket stationServer = new ServerSocket(4000);
        computing = stationServer.accept();
        System.out.println("computing connected");

        String computingMessage = recieveFromComputing();
  
        if(computingMessage.equals("getWaterPressure")) {
            //Send Water level to computing
            sendWaterLevel();
        }
       if(computingMessage.equals("Close the dam gates")) {
            //Send Water level to computing
            sendToComputing("The gates closed");
        }

        
    }
    private static void sendWaterLevel() throws  IOException {
            sendToComputing("22");
    }

    private static String recieveFromComputing() throws IOException{
          //Recieve message from Computing Node
        InputStreamReader inComputing= new InputStreamReader(computing.getInputStream());
        BufferedReader bfComputing = new BufferedReader(inComputing);
        return bfComputing.readLine();
    }
    private static void sendToComputing(String message) throws IOException {
        //Send message to Computing Node
        PrintWriter prComputing = new PrintWriter(computing.getOutputStream());
        prComputing.println(message);
        prComputing.flush();
    }
}
