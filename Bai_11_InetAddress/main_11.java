/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_11_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class main_11 {
    public static void main(String[] args) {
        String domain = "www.google.com";
        try {
            InetAddress address = InetAddress.getByName(domain);
            System.out.println("ten mien : " + domain);
            System.out.println("dia chi IP : "+ address.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(main_11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            // vd 2 lay ip localhost
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("dia chi ip localhost : "+localhost.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(main_11.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
