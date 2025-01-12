/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_15_remoteclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bai_15_RemoteClient {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {
                System.out.println("-------MENU------");
                System.out.println("1 : shutdown computer");
                System.out.println("2 : restart computer");
                System.out.println("3 : cancel command");
                System.out.println("4 : screenshot");
                System.out.println("5 : my facebook accout");
                System.out.println("6 : my github accout");
            
                System.out.println("0 : exit system");
                int luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        writer.println("shutdown");
                        System.out.println(reader.readLine()); // doc phan hoi tu server
                        writer.flush();
                        break;
                    case 2:
                        writer.println("restart");
                        System.out.println(reader.readLine());
                        writer.flush();
                        break;
                    case 3:
                        writer.println("cancelCommand");
                        System.out.println(reader.readLine());
                        writer.flush();
                        break;
//                    case 4:
//                        writer.println("screenshot");
//                        System.out.println(reader.readLine()); // doc phan hoi tu server
//                        writer.flush();
//                        int imageSize = Integer.parseInt(reader.readLine());
//                        byte[] imageByte = new byte[imageSize];
//                        int byteRead = socket.getInputStream().read(imageByte);
//                        if(byteRead > 0){
//                            System.out.println("nhap ten anh :");
//                            String fileName = sc.nextLine();
//                            Path imagePath = Paths.get(fileName + "png");
//                            Files.write(imagePath, imageByte);
//                            System.out.println("done!");
//                            
//                        }
//                        break;
                    case 4:
                        writer.println("screenshot");
                       ///       System.out.println(reader.readLine()); // Nhận phản hồi từ server
                        writer.flush();

                     
                            int imageSize = Integer.parseInt(reader.readLine());
                            byte[] imageBytes = new byte[imageSize];
                            int byteRead = socket.getInputStream().read(imageBytes);

                            if (byteRead > 0) {
                             
                                System.out.println("nhap ten anh :");
                                String fileName = sc.nextLine();
                                Path imagePath = Paths.get(fileName + ".png");
                                Files.write(imagePath, imageBytes);
                                System.out.println("done!");

                            } else {
                                System.out.println("Không nhận được dữ liệu từ server.");
                            }
                       
                        break;
                    case 5:
                        writer.println("facebook");
                        System.out.println(reader.readLine());
                        writer.flush();
                        break;

                    case 0:
                        writer.println("exit"); // Gửi lệnh "exit" tới server
                        System.out.println("Thoát chương trình...");
                        Thread.sleep(6000);
                        exit = true; // Thoát vòng lặp
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            writer.close();
            reader.close();
            socket.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
