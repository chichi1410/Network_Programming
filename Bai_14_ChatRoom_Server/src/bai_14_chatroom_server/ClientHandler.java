/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_14_chatroom_server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
// Clienthandler : nguoi xu ly khach hang
public class ClientHandler implements Runnable {

    private Socket mySocket;
    private ChatServer chatServer;  
    private String ID;
    private InputStream input;
    private OutputStream output;

    public ClientHandler(Socket mySocket, String ID , ChatServer chatServer) {
        this.ID = ID;
        this.mySocket = mySocket;
        this.chatServer = chatServer;
        try {
            this.input = mySocket.getInputStream();
            this.output = mySocket.getOutputStream();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while((bytesRead = input.read(buffer)) != -1){
                String message = new String(buffer , 0 , bytesRead);
          chatServer.broadcastMessage(this.ID + ": "+ message);
            }
        } catch (Exception e) {
        }
    }
    public void sendMessage(String message){
        try {
            output.write(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  

}
