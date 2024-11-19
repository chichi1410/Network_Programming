/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_10_LibraryMannagement_multiThreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Student extends Thread {

    private long ID;
    private Library lib;
    private String title;

    public Student(long ID,Library lib, String title) {
        this.lib = lib;
        this.title = title;
        this.ID = ID;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 5; i++) {
               
                lib.borrowBook(ID,title);
                sleep((long) (Math.random() * 7000));
              
                lib.returnBook(ID,title);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
