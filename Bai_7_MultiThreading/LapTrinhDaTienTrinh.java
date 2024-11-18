/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_7_MultiThreading;

//vấn đề gặp ở đây là code chạy từ trên xuống theo trình tự
//nếu chạy quá dài thì sẽ xử lý rất lâu nên cần đa luồng để xử lý cùng 1 lúc
// xu ly  nhieu luong cung 1 luc (Multi threading)

public class LapTrinhDaTienTrinh {
    public static void main(String[] args) {
        System.out.println("first hello ");
                
//        for(int i=0 ; i<999 ; i++){
//            System.out.println(" vs x"+i);
//        }
//        ddang chay 2 luong cung 1 luc
         Thread th = new taskA();
         th.start();
         Thread th1 = new Thread(new taskB());
         th1.start();
         Thread th3 = new taskC();
         th3.start();
        System.out.println("last hello");
    }
}
