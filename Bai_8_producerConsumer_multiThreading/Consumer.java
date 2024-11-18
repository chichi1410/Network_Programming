/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_8_producerConsumer_multiThreading;

//
//public class Consumer extends Thread{
//    private int ID;
//    private Buffer buffer;
//
//    public Consumer(int ID, Buffer buffer) {
//        this.ID = ID;
//        this.buffer = buffer;
//    }
// 
//    
//    @Override
//    public void run() {
//        int i =0;
//        while (true) {            
//            if( buffer.getSize() > 0){
//                try {
//                    buffer.removeProduct( this.ID);
//                   sleep((long)Math.random()*100);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    
//}

public class Consumer extends Thread {
    private int ID; // Mã khách hàng
    private Buffer buffer; // Tham chiếu đến kho

    public Consumer(int ID, Buffer buffer) {
        this.ID = ID;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            buffer.removeProduct(ID);
            try {
                Thread.sleep((long) (Math.random() * 1000)); // Dừng một chút để mô phỏng tiêu thụ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
