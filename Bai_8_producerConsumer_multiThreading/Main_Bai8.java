/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_8_producerConsumer_multiThreading;

// buffer : đệm
// capacity : dung tich
// product : san pham
// consumer : nguoi tieu dung
//producer consumer nha san xuat nguoi tieu dung
public class Main_Bai8 {
    public static void main(String[] args) {
        // Tạo kho với sức chứa tối đa 5 sản phẩm
        Buffer buffer = new Buffer(5);

        // Tạo 2 nhà sản xuất và 2 khách hàng
        Producer producer1 = new Producer(1, buffer);
        //Producer producer2 = new Producer(2, buffer);
        Consumer consumer1 = new Consumer(101, buffer);
       // Consumer consumer2 = new Consumer(102, buffer);

        // Bắt đầu các luồng
        producer1.start();
       // producer2.start();
        consumer1.start();
       // consumer2.start();
    }
}
