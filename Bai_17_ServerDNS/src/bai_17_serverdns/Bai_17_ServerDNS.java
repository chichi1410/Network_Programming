/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_17_serverdns;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Admin
 */
public class Bai_17_ServerDNS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           try {
            // datagramsocket được sử dụng để gửi và nhận các gói dữ liệu day la giao thuc DNS  
            DatagramSocket socket = new DatagramSocket(9876);
            System.out.println("DNS server is running.....");

            // gia lap 1 bảng định danh 
            // b1 tạo 1 mảng 2 chiều
            String[][] dnsTable = {
                {"www.google.com" , "8.8.8.8" },
                {"www.titv.com" , "31.13.65.36"},
                {"www.example.com" , "192.168.1.100"}
            };
            // lien tuc nhan cac gioi tin truy van xem ten mien thuoc dia chi ip nao
           
            while(true){
                
                byte[] receiveData = new byte[1024];
                // tao va nhan package
                DatagramPacket receivePackage = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePackage);
                
                // truy van IP tu domain name (ten mien )
                String domainName = new String(receivePackage.getData() , 0 ,receivePackage.getLength());
                domainName = domainName.trim();
                domainName = domainName.toLowerCase();
                
                String response  = "not found"; // ko tim thay
                for (String[]  entry : dnsTable) {
                    if(entry[0].equals(domainName)){
                        response = entry[1];
                        break;
                    }
                }
                
                // phan hoi
                InetAddress clientAddress = receivePackage.getAddress();
                int clientPort = receivePackage.getPort();
                byte[] responseData = response.getBytes();
                DatagramPacket sendPackage = new DatagramPacket(responseData,
                        responseData.length , clientAddress , clientPort);
                socket.send(sendPackage);
                
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
