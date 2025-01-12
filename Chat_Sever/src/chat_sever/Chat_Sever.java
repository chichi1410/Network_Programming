/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat_sever;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Chat_Sever {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int port = 99;
            // tao sever socket va lang nghe
            ServerSocket serverSocket = new ServerSocket(port);
            
            // chap nhan nhieu ket noi tu client
            while (true) {                
                 Socket clientSocket = serverSocket.accept();
                 MyProcess mp = new MyProcess(clientSocket);
                 mp.start();
            }
            // bat dau sleep
//            Thread.sleep(5000);
//            clientSocket.close();
//            serverSocket.close(); 
            
        } catch (Exception e) {
        }
    }
    
}
