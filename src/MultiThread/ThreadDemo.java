package MultiThread;


class  Thread_1 extends  Thread {
    @Override
    public void run() {

        for (int i = 1; i <10 ; i=i+2) {
            System.out.println(i+" ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class  Thread_2 extends  Thread {
    @Override
    public void run() {

        for (int i = 2 ; i <10 ; i = i +2) {
            System.out.println(i+"  ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
            Thread t1 = new Thread_1();
            Thread t2 = new Thread_2();

            t1.start();
            t2.start();
    }
}
