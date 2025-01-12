/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_15_remoteserver;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class Bai_15_RemoteServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("client connected : " + socket.getInetAddress().getHostAddress());
                // tao luong thuc thi
                Thread thread = new Thread(
                        () -> handleClientRequest(socket)
                );
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //handle client request : xu ly yeu cau cua khach hang
    // request : loi yeu cau
    public static void handleClientRequest(Socket socket) {
        try {
            // new InputStreamReader(...): Chuyển đổi byte stream (dữ liệu thô)
            //từ InputStream sang character stream (chuỗi ký tự).
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // luong nhan
            PrintWriter writer = new PrintWriter(socket.getOutputStream()); // luong gui
            String request = reader.readLine();
            while (true) {
                if (request.equalsIgnoreCase("shutdown")) {
                    Runtime.getRuntime().exec("shutdown -s -t 3600");
                    writer.println("shutdown computer.....");
                    writer.flush();
                } else if (request.equalsIgnoreCase("restart")) {
                    Runtime.getRuntime().exec("shutdown -r -t 3600");
                    writer.println("restart computer.....");
                    writer.flush();
                } else if (request.equalsIgnoreCase("cancelCommand")) {
                    Runtime.getRuntime().exec("shutdown -a");
                    writer.println("cancel command successfully !");
                    writer.flush();
                } else if (request.equalsIgnoreCase("exit")) {
                    writer.println("Exiting in 5 second...");
                    try {
                        Thread.sleep(5000); // Chờ 5 giây
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(0); // Thoát chương trình
                } else if (request.equalsIgnoreCase("screenshot")) {
                    // chup anh 
                    BufferedImage screenshot = new Robot().createScreenCapture(
                            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
////                    Rectangle : hinh chu nhat
////                    toolkit : bo cong cu
////                    getDefaultToolkit : lay cong cu mac dinh 
////                    getScreenSize  : lay kich thuoc man hinh
                    // chup anh man hinh dong dai phia sau la quy dinh kich co image
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot, "png", baos);
                    byte[] imageBytes = baos.toByteArray();
                    baos.close();
                    writer.println(imageBytes.length);
                    writer.flush();
                    socket.getOutputStream().write(imageBytes);
                }else if(request.equalsIgnoreCase("facebook")){
                  Runtime.getRuntime().exec("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" facebook.com/nguyenhoa.son4");

                    writer.println("done!");
                    writer.flush();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static void exitThread() {
//        try {
//            Thread.sleep(1000);
//            System.exit(0);
//        } catch (Exception e) {
//        }
//
//    }
}
