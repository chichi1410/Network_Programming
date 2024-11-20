/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_12_Connect_URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Admin
 */
public class VD1_URL {
    public static void main(String[] args) {
        try {
            // tao doi tuong URL
            String URLString = "https://github.com/chichi1410";
            URL url = new URL(URLString);
            
            // doc du lieu
            InputStreamReader is = new InputStreamReader(url.openStream());
            // doc tung dong
            BufferedReader br = new BufferedReader(is);
            String line;
            while((line  = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
