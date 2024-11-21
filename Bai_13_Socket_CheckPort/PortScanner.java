/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_13_Socket_CheckPort;

import java.net.Socket;

/**
 *
 * @author Admin
 */
public class PortScanner {
    public static void main(String[] args) {
        checkPort("localhost");
    }
    public static void checkPort(String urlString){
        int StartPort = 1;
        int endPort = 10000;
        System.out.println("dang quet cac port cua may : "+urlString);
        for(int i = StartPort ; i <= endPort ; i++){
            try {
                Socket socket = new Socket(urlString, i);
                System.out.println("cong "+i+" dang mo");
                socket.close();
            } catch (Exception e) {
            }
        }
        System.out.println("quet cong hoan tat");
    }
}
