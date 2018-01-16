//TCPClient
//BBB reverse "SRQP" transfer to CCC 
package orderreversetcpclient;

//TCPClient.java
import java.io.*;
import java.net.*;

class OrderReverseTCPClient {
   public static void main(String argv[]) throws Exception
   {
      String sentence;
      String modifiedSentence;
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      Socket clientSocket;
      clientSocket = new Socket("27.147.162.222", 6323);
      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      sentence = inFromUser.readLine();
      outToServer.writeBytes(sentence + '\n');
      modifiedSentence = inFromServer.readLine();
      System.out.println("FROM SERVER: " + modifiedSentence);
      clientSocket.close();
   }
}