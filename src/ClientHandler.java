import java.io.*; 
import java.net.*;
import java.util.Random; 
class ClientHandler extends Thread  
{ 
    final Socket s = null; 
      
    private  Socket client;
    private  Random rand = new Random();
    private static int threadcount =0;
    private int threadid;
    // Constructor 
    public ClientHandler(Socket s)  
    { 
        this.client = s; 
        threadid  = threadcount;
        threadcount++;
    } 
  
    @Override
    public void run()
    { 
        while(true) {
            try{
                    String message = recieveFromClient();
                   
                    if (!message.contains("close") && !message.contains("open") && !message.contains("rotate") ) {
                        String val = Double.toString(rand.nextDouble()*10.0);
                        sendToClient(val);
                    }
                    else if(message.contains("close")) {
                        System.out.println(message);
                        sendToClient("closed!");
                    } else if(message.contains("open")) {
                        System.out.println(message);
                        sendToClient("opened!");
                    }
                    else if(message.contains("rotate")) {
                        System.out.println(message);
                        sendToClient("rotated!");
                    }
            } catch(IOException e){
                //e.printStackTrace();
            }   //
        }
    }
    private  String recieveFromClient() throws IOException{
        //Recieve message from Computing Node
      InputStreamReader inClient= new InputStreamReader(this.client.getInputStream());
      BufferedReader bfClient = new BufferedReader(inClient);
      return bfClient.readLine();
  }
  private  void sendToClient(String message) throws IOException {
    //Send message to Computing Node
    PrintWriter prClient = new PrintWriter(this.client.getOutputStream());
    prClient.println(message);
    prClient.flush();
}
} 