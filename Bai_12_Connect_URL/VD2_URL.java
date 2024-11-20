/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_12_Connect_URL;

// check websites co hoat dong hay ko

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class VD2_URL {
    public static void main(String[] args) {
        String[] websites = {
        "https://google.com",
        "https://facebook.com",
        "https://vnexpress1.net"};
        
        for (String website : websites) {
            checkWebsites(website);
        }
    }
    public static void checkWebsites(String urlString){
        try {
            URL url = new URL(urlString);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            //http code
//            thanh cong : 200
//            ko co quyen truy cap : 401
//            ko co  quyen truy xuat : 403
//            loi tu sever :500
//            trang ko tim thay : 404
              int responsecode = conn.getResponseCode(); // lay ra cac so nhu tren
              if(responsecode == 200){
                  System.out.println(urlString +" connect success!");
              }else {
                  System.out.println(urlString +" error 404");
              }
             

        } catch (Exception e) {
            System.out.println(urlString + " không thể kết nối. Lỗi: " + e.getMessage());
        }
    }
}
