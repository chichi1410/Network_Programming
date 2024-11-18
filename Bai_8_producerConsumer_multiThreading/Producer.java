/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_8_producerConsumer_multiThreading;

//public class Producer extends Thread{
//    private int ID;
//    private Buffer buffer;
//
//    public Producer(int ID, Buffer buffer) {
//        this.ID = ID;
//        this.buffer = buffer;
//    }
//
//  
//    
//    @Override
//    public void run() {
//        int i =0;
//        while (true) {            
//            if(buffer.getCapacity() > buffer.getSize()){
//                try {
//                    buffer.addProduct(i++, this.ID);
//                    sleep((long)Math.random()*100);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    
//}

public class Producer extends Thread {
    private int ID; // Mã nhà sản xuất
    private Buffer buffer; // Tham chiếu đến kho

    public Producer(int ID, Buffer buffer) {
        this.ID = ID;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int product = 0; // Sản phẩm bắt đầu từ 0
        while (true) {
            buffer.addProduct(product++, ID);
            try {
                Thread.sleep((long) (Math.random() * 1000)); // Dừng một chút để mô phỏng sản xuất
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
