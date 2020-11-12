import java.io.*; 
import java.net.*;
import java.util.Random;

public class Intermediate {
    private static Socket client;
   
    public static void main(String[] args) throws IOException{
        /**Connection Part */
        
        //Conncect to Computing and Accept
        ServerSocket serverClient = new ServerSocket(5000);
      

        Socket clientStation =  new Socket("localhost",4000);
       
       
        
        
        
        while(true){
            // /**Connection Part */
            client = serverClient.accept();
            System.out.println("decision connected");

        Thread t1 = new IntermediateHandler(client,clientStation);
       
        try{
        /**Protocol */
            t1.run();
           
           
         /**Protocol */
       

            
       } catch(Exception e) {
          client.close();
       
           e.printStackTrace();
       }
    }
    
    }
}
