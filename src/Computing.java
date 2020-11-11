import java.io.*;
import java.net.*;

public class Computing {
    private static Socket decision;
    private static Socket stationServer;
    public static void main(String[] args) throws IOException{
        //Conncect to Decision and Accept
        ServerSocket computingServer = new ServerSocket(5000);
        decision = computingServer.accept();
        System.out.println("Decision connected");
        
        //Conncect to Station Node
        stationServer = new Socket("localhost",4000);

        String decisionMessage =  recieveFromDecision();
      
        if(decisionMessage.equals("getWaterPressure")){
              //Get the water level from station
            computeWaterPressure(decisionMessage);
          }
        if(decisionMessage.equals("Close the dam gates")){
            //Close the dam gates
              closeTheDam(decisionMessage);
         }
    }
    private static void computeWaterPressure(String message) throws IOException{
        //Todo
        /**
         * send the decision message to the station node
         * recieve the station message then send it to decision node
         */
              sendTOStation(message);
              sendTODecision(recieveFromStation());
    }
    private static void closeTheDam(String message) throws IOException{
       //Todo
        /**
         * send the decision message to the station node
         * recieve the station message then send it to decision node
         */
            sendTOStation(message);
            System.out.println(recieveFromStation());
        
  }
    private static String recieveFromDecision() throws IOException{
        //Recieve message from Decision Node
        InputStreamReader inDecision = new InputStreamReader(decision.getInputStream());
        BufferedReader bfDecision = new BufferedReader(inDecision);
        return bfDecision.readLine();
    }
    private static void sendTOStation(String message) throws IOException{
        //Send message to Station Node
        PrintWriter prStation = new PrintWriter(stationServer.getOutputStream());
        prStation.println(message);
        prStation.flush();
    }
    private static String recieveFromStation() throws IOException{
         //Recieve message from Station Node
        InputStreamReader inStation = new InputStreamReader(stationServer.getInputStream());
        BufferedReader bfStation  = new BufferedReader(inStation);
        return bfStation.readLine();
    }
        private static void sendTODecision(String message) throws IOException{
             //Send message to Decision Node
            PrintWriter prDecision = new PrintWriter(decision.getOutputStream());
            prDecision.println(message);
           prDecision.flush();
        }

}
