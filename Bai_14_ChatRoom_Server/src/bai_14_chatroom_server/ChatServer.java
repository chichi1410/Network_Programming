/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_14_chatroom_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChatServer {
    private static final int PORT = 5000;
    private List<ClientHandler> clients = new ArrayList<>();
    public void startSever(){
        try {
            // web socket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Sever Started . Listening on port : " + PORT);
            // client connect to sever 
            while (true) {                
                Socket clientSocket = serverSocket.accept();
                System.out.println("new client connected : "+ clientSocket.getInetAddress().getHostAddress());
                ClientHandler clienthandler = new ClientHandler(clientSocket , System.currentTimeMillis()+"", this);
                clients.add(clienthandler);
                new Thread(clienthandler).start();
            } 
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void broadcastMessage(String message){
       for(ClientHandler client : clients){
           client.sendMessage(message);
       } 
    }  
}
