
package Bai_8_producerConsumer_multiThreading;
//
//import java.util.ArrayList;
//
///**
// *
// * @author Admin
// */
//// buffer : đệm
//// capacity : dung tich
//// product : san pham
//// consumer : nguoi tieu dung
//public class Buffer  {
//   private int capacity;
//   //danh sach san pham
//   private ArrayList<Integer> products = new ArrayList<>();
//
//    public Buffer(int capacity) {
//        this.capacity = capacity;
//        products = new ArrayList<>();
//    }
//   
//   
//   
////   public void addProduct(int product , int productID){
////       System.out.println(">>>>-------------------------------------------");
////       System.out.println("nha san xuat "+productID +" san pham "+product);
////       products.add(product);
////       System.out.println("so luong ton kho: "+products.size());
////   }
////   public void removeProduct(int consumerID ){
////       System.out.println("<<<<<---------------------------------------");
////       System.out.println("khach hang "+consumerID+" da mua san pham "+products.get(0));
////       products.remove(0);
////       System.out.println("so luong ton kho :" + products.size());
////   }
//    public synchronized void addProduct(int product, int productID) {
//    while (products.size() >= capacity) {
//        try {
//            wait(); // Chờ nếu kho đã đầy
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    System.out.println(">>>>-------------------------------------------");
//    System.out.println("Nhà sản xuất " + productID + " sản xuất sản phẩm " + product);
//    products.add(product);
//    System.out.println("Số lượng tồn kho: " + products.size());
//    notifyAll(); // Thông báo cho các luồng đang chờ
//}
//
//public synchronized void removeProduct(int consumerID) {
//    while (products.size() <= 0) {
//        try {
//            wait(); // Chờ nếu kho rỗng
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    System.out.println("<<<<<---------------------------------------");
//    System.out.println("Khách hàng " + consumerID + " đã mua sản phẩm " + products.get(0));
//    products.remove(0);
//    System.out.println("Số lượng tồn kho: " + products.size());
//    notifyAll(); // Thông báo cho các luồng đang chờ
//}
//
//   public int getSize(){
//       return products.size();
//   }
//   public int getCapacity(){
//       return capacity;
//   }
//}
import java.util.ArrayList;

public class Buffer {
    private int capacity;
    private ArrayList<Integer> products; // Danh sách sản phẩm trong kho

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.products = new ArrayList<>();
    }

    // Thêm sản phẩm vào kho
    public synchronized void addProduct(int product, int producerID) {
        while (products.size() >= capacity) {
            try {
                System.out.println("Kho đầy, nhà sản xuất " + producerID + " đang chờ...");
                wait(); // Chờ nếu kho đầy
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products.add(product);
        System.out.println("Nhà sản xuất " + producerID + " sản xuất sản phẩm " + product);
        System.out.println("Số lượng tồn kho: " + products.size());
        notifyAll(); // Thông báo cho các luồng khác
    }

    // Lấy sản phẩm ra khỏi kho
    public synchronized void removeProduct(int consumerID) {
        while (products.isEmpty()) {
            try {
                System.out.println("Kho rỗng, khách hàng " + consumerID + " đang chờ...");
                wait(); // Chờ nếu kho rỗng
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int product = products.remove(0);
        System.out.println("Khách hàng " + consumerID + " đã mua sản phẩm " + product);
        System.out.println("Số lượng tồn kho: " + products.size());
        notifyAll(); // Thông báo cho các luồng khác
    }

    public int getSize() {
        return products.size();
    }

    public int getCapacity() {
        return capacity;
    }
}
