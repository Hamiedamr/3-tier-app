import java.io.*;
import java.net.*;

public class Decision {
    private static Socket computing;
    public static void main(String[] args) throws IOException{
        //Connect to Computing Node
        computing = new Socket("localhost",5000);
        getWaterPressure("getWaterPressure");
        
       
       
    }
    private static void getWaterPressure(String message) throws IOException{
        //Todo 
        /**
         * Send message to computing node at port 5000
         * Recieve messafe from computing node at port 5000
         * Compare the received water level with threshold value and send decisison at port 5001
         */
        sendToComputing(message);
        String waterLevel = recieveFromComputing();
        System.out.println(waterLevel);
    }
    private static void controlDamGate(String message) throws IOException{
        sendToComputing(message);
    }
    private static String recieveFromComputing() throws IOException{
        //Recieve message from Computing Node
        InputStreamReader inCompute = new InputStreamReader(computing.getInputStream());
        BufferedReader bfCompute  = new BufferedReader(inCompute);
        return  bfCompute.readLine();
      
    }
    private static void sendToComputing(String message) throws IOException {
                //Send message to Computing Node

        PrintWriter pr = new PrintWriter(computing.getOutputStream());
        pr.println(message);
        pr.flush();
    }
    
}
