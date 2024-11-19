/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai_9_Synchronized_DongBoHoaTienTrinh;
//counter : quay tinh tien
//count : dem
//dong bo : tai 1 thoi diem chi co 1 thread dc tuong tac voi gia tri
//synchronized : dong bo tai 1 thoi diem chi cos 1 thread goi
// vd cùng 1 thời điểm chỉ có 1 hành động rút tiền ra hoặc nộp tiền vô
// ko được có 2 hành động cùng 1 lúc

//them tu khoa synchronized vao sau public
public class Main_10 {
    public static void main(String[] args) {
       Counter counter = new Counter();
       Thread t1 = new Thread(
       ()->{
           for(int i=0 ; i<1000 ; i++){
               counter.increament();
           }
       }
       );
       Thread t2 = new Thread(
       ()->{
           for(int i=0 ; i<1000 ; i++){
               counter.increament();
           }
       }
       );
        
       t1.start();
       t2.start();
       
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        System.out.println("counter :" + counter.getCount()  );
        // khi run thif ket qua luc dung luc sai do thieu dong bo
        // khi bo tu khoa synchronized vao ham increament thi se khac phuc dc
        
    }
}
