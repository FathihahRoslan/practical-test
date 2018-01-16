package OrderReverseTCPServer;

import java.io.*;
import java.net.*;

class AAA{
   public static void main(String argv[]) throws Exception
   {
      String clientSentence;
      //String capitalizedSentence = null;
      ServerSocket welcomeSocket = new ServerSocket(6333);
      while(true) {
         Socket connectionSocket = welcomeSocket.accept();
         BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
         DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
         clientSentence = inFromClient.readLine();
         String sendToClient = new StringBuilder(clientSentence).reverse().toString()+'\n';
         outToClient.writeBytes(sendToClient) ;
      }
   }
}