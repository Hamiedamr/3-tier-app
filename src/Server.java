import java.io.*; 
import java.net.*;
import java.util.Random; 
public class Server {
    private static Socket client;
    private static Random rand = new Random();
    public static void main(String[] args) throws IOException{
        /**Connection Part */
        
        //Conncect to Computing and Accept
        ServerSocket server = new ServerSocket(4000);
        while(true){
        client = server.accept();
        System.out.println("intermediate connected");
        // /**Connection Part */
        
        try{
        /**Protocol */
            Thread t1 = new ClientHandler(client);
        
            t1.run();
           
         /**Protocol */
       

            
       } catch(Exception e) {
           client.close();
       
           e.printStackTrace();
       }
    }
    
    }
}
