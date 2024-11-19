/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_10_LibraryMannagement_multiThreading;

/**
 *
 * @author Admin
 */
public class Main_10 {

    public static void main(String[] args) {
        Library l = new Library();
        l.addBook(new Book("tam quoc chi", "la quan trung", true));
        l.addBook(new Book("tay du ky", "ngo thua an", true));
        l.addBook(new Book("hong lau mong", "tau tuyet can", true));
        l.addBook(new Book("thuy hu", "thi nai am ", true));
        l.addBook(new Book("ly vu qua", "vo danh", true));
        l.addBook(new Book("dai chu tien lai", "nettruyen", true));
        l.addBook(new Book("xuan thu ba do", "nettruyen", true));
        l.addBook(new Book("dau la dai luc", "vo danh", true));
        l.addBook(new Book("titanic", "James Cameron", true));

        l.displayBooks();

        // muon va tra sach
//        l.borrowBook("tam quoc chi");
//        l.borrowBook("tam quoc chi");
//        l.returnBook("tam quoc chi");
//        l.borrowBook("tam quoc chi");

         Thread t1 = new Student(1,l, "tam quoc chi");
         Thread t2 = new Student(2,l, "tam quoc chi");
        
         Thread t3 = new Student(3,l, "hong lau mong");
         Thread t4 = new Student(4,l, "hong lau mong");
         Thread t5 = new Student(5,l, "dai chu tien lai");
         Thread t6 = new Student(6,l, "dai chu tien lai");
         
         t1.start();
         t2.start();
         t3.start();
         t4.start();
         t5.start();
         t6.start();
       
    }
}
