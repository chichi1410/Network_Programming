/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_16_severudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Admin
 */
public class Bai_16_SeverUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1204];
            int count = 0;
            while (true) {
                DatagramPacket receivePackage = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePackage);
                // lay data chinh tu 0 den
                String receiveMessage = new String(receivePackage.getData(), 0, receivePackage.getLength());
                if (receiveMessage.trim().length() > 0) {
                    System.out.println("receiveMessage : " + receiveMessage);
                }

                count++;
                if (count == 1000000) {
                    break;
                }
            }
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
