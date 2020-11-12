import java.io.*;
import java.net.*;

public class Client {
    private static Socket server;
    public static void main(String[] args) throws IOException{
        
        /**Connection Part */

        //Connect to Computing Node
        server = new Socket("localhost",5000);
        
        /**Connection Part */
       
        /**Protocol */
       
           
            while(true){
    
                getWaterPressure();
                }
         /**Protocol */
       
       
    }
    private static void getWaterPressure() throws IOException{
        //Todo 
        /** 
         * Send message to computing node at port 5000
         * Recieve messafe from computing node at port 5000
         * Compare the received water level with threshold value and send decisison at port 5001
         */
        sendToServer("getWaterPressure",server);
        String message="";
        try{
            message = recieveFromServer(server);
        Float waterLevelF = Float.parseFloat(message);
        if(waterLevelF > 5.5f) {
            sendToServer("close",server);
        } else if(waterLevelF <= 5.5f) {
            sendToServer("open",server);
            }
        }catch(NumberFormatException e){
                
            }
        System.out.println(message);
       
        
    }
    private static String recieveFromServer(Socket s) throws IOException{
        //Recieve message from Computing Node
        InputStreamReader inS = new InputStreamReader(s.getInputStream());
        BufferedReader bfS  = new BufferedReader(inS);
        return  bfS.readLine();
      
    }
  
    private static void sendToServer(String message,Socket s) throws IOException {
                //Send message to Computing Node

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(message);
        pr.flush();
    }

    
}