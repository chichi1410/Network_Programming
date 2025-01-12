/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_16_clientudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Admin
 */
public class Bai_16_ClientUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            
            int serverPort = 9876;
            int i =0;
            while( i < 1000){
           
            String message = "hello server UDP";
            
            byte[] senData = message.getBytes();
            DatagramPacket senPackage = new DatagramPacket(senData , senData.length , serverAddress , serverPort);
            
            socket.send(senPackage);
            socket.close();
            i++;
            }
            
        } catch (Exception e) {
        }
    }
    
}
