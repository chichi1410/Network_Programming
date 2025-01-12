/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_17_clientdns;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Bai_17_ClientDNS {

    /**
     * @param args the command line arguments
     */
    // domain Name : ten mien
     //receive : nhan dc
    public static void main(String[] args) {
        
        try {
            DatagramSocket socket = new DatagramSocket();
             InetAddress serverAddress = InetAddress.getByName("localhost");
             int serverPort = 9876;
             
             Scanner sc = new Scanner(System.in);
             while (true) {                
                 System.out.println("nhap vao ten mien IP can tim : ");
                 String domainName = sc.nextLine();
                 
                 // gui truy van
                 byte[] sendData = domainName.getBytes();
                DatagramPacket sendPackage = new DatagramPacket(sendData,
                        sendData.length , serverAddress , serverPort);
                socket.send(sendPackage);
                // nhan phan hoi 
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePackage = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePackage);
                
                // xuat ket qua 
                String ip = new String(receivePackage.getData(), 0 , receivePackage.getLength());
                 System.out.println("IP : "+ip);
            }
            
        } catch (Exception e) {
        }
     
     

    }
}
