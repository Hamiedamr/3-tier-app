import java.io.*; 
import java.net.*;
import java.util.Random; 
public class Server {
    private static Socket clientStation;
    private static Random rand = new Random();
    public static void main(String[] args) throws IOException{
        /**Connection Part */
        
        //Conncect to Computing and Accept
        ServerSocket station = new ServerSocket(4000);
        
        
        while(true){
            clientStation = station.accept();
            System.out.println("compute connected");
        // /**Connection Part */
        Thread t1 = new ClientHandler(clientStation);
       
        try{
        /**Protocol */
            t1.run();
           
         /**Protocol */
       

            
       } catch(Exception e) {
        clientStation.close();
       
           e.printStackTrace();
       }
    }
    
    }
}
