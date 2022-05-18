package MultiThread;

import java.util.Scanner;

public class BTTG_1 {

    public static void main(String[] args) {
    InputRectangle t1 = new InputRectangle();
    t1.start();

    }
}
// tuyen 1 : ham cho phep nhap vao hai so thuc la hai canh cua hinh chu nhat
    class InputRectangle extends  Thread {
        int a,b;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in) ;
        a = scanner.nextInt();
        System.out.println("Chieu dai :" + a);
        b = scanner.nextInt();
        System.out.println(" chieu rong : "+b);

    }

}

//tuyen 2 : tinh dien tich tu input duoc nhap vao o tuyen 1

    class RecArea extends Thread{
    int a,b;
    int s = 0;
    RecArea(int x, int y ) {
        a = x;
        b = y;
    }

        @Override
        public void run() {
            s = a*b;
            System.out.println("Rectangle area : " +s);
        }
        public long getResult() {
        return s;
        }

    }
// tuyen 3 : tinh chu vi hinh chu nhat tu input duoc nhap vao o tuyen 1
    class  RecPeri extends  Thread {
    int a,b;
    int p = 0;
    RecPeri(int x , int y) {
        a = x ;
        b = y;

    }

    @Override
    public void run() {
        p = (a+b)*2;
        System.out.println("perimeter of a rectangle : " +p);

    }
    public long getResult() {
        return p;
    }
}


