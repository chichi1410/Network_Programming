/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_7_MultiThreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class taskB implements Runnable{

    @Override
    public void run() {
        while(true){
              System.out.println("cong viec BBBBBB");
            try {
              
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(taskB.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
    
}
