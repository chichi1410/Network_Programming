/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_14_chatroom_client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ChatClient {   
    private static final String url = "localhost";
    private static final int port = 5000;
    
    public void startClient(){
        try {
            Socket socKet = new Socket(url, port);
             System.out.println("connected to server  ");
             // lien tuc doc du lieu tu sever
             ClientListener client = new ClientListener(socKet);
             new Thread(client).start();
             //lien tuc doc du lieu tu scanner
             OutputStream output = socKet.getOutputStream();
             Scanner sc = new Scanner(System.in);
             while (true) {                
                String message = sc.nextLine();
                output.write(message.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
