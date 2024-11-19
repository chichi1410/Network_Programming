/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_10_LibraryMannagement_multiThreading;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Library {
    private ArrayList<Book> books;
    
    public Library(){
        books = new ArrayList<>();
    }
    
    public void addBook(Book book){
        books.add(book);
        System.out.println("da them sach :" +book.getTitle());
    }
    // cho muon sach
    public synchronized void borrowBook(long ID ,String title){
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)){
                if(book.isAvailable()){
                    book.setAvailable(false);
                    System.out.println(ID + ": da cho muon sach :" +title);
                    return;
                }
            }
        }
        System.out.println("----ko the cho muon sach : "+title);
    }
    // tra lai sach da cho muon
   public synchronized void returnBook(long ID ,String title){
   for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)){
                if(!book.isAvailable()){
                    book.setAvailable(true);
                    System.out.println(ID + " : da tra sach :" +title);
                    return;
                }
            }
        }
        System.out.println("----ko the tra sach : "+title);
    }
   
   // hien thi danh sach cac cuon sach trong thu vien
   public synchronized void displayBooks(){
       System.out.println("-------library books--------");
       for (Book book : books) {
           System.out.println(book.toString());
       }
   }
}
