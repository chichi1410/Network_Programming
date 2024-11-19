/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_9_Synchronized_DongBoHoaTienTrinh;

/**
 *
 * @author Admin
 */
public class Counter {
    private int count;

    public int getCount() {
        return count;
    }
    
    // tang gia tri 
    public synchronized void increament(){
        count++;
    }
}
