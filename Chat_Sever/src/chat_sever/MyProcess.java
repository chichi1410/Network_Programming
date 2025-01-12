/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_sever;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
// process : qua trinh
public class MyProcess extends Thread{
    private Socket socket;
    
    public MyProcess(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
//            Thread.sleep(5000);
//            socket.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
             String message;
            // Chat
            while(true){
                // Nhận tin nhắn
                message=reader.readLine();
                System.out.println("client: "+ message);
                 // Gủi tin nhắn
                System.out.println("Sever: ");
                message = sc.nextLine();
                writer.println(message);
                writer.flush();
                
            }
            
        } catch (Exception e) {
        }
    }
    
    
    
    
    
}
