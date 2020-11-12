import java.io.*; 
import java.net.*;
import java.util.Random; 
public class Intermediate {
    private static Socket client;
    private static Random rand = new Random();
    public static void main(String[] args) throws IOException{
        /**Connection Part */
        
        //Conncect to Computing and Accept
        ServerSocket serverDecision = new ServerSocket(5000);
        Socket clientStation =  new Socket("localhost",4000);
        while(true){
        client = serverDecision.accept();
        System.out.println("client connected");
        // /**Connection Part */
        
        try{
        /**Protocol */
            Thread t1 = new IntermediateHandler(client,clientStation);
        
            t1.run();
           
         /**Protocol */
       

            
       } catch(Exception e) {
           client.close();
       
           e.printStackTrace();
       }
    }
    
    }
}
