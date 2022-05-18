package MultiThread;

public class MultiThreadDemo {
        FacThread facThread = new FacThread(2);
        SumThread sumThread = new SumThread(3);
        SumPowThread sumPowThread = new SumPowThread(2,1);

    public MultiThreadDemo() {
        facThread.start();
        sumThread.start();
        sumPowThread.start();

        try {
            facThread.join();
            sumThread.join();
            sumPowThread.join();
            long s = facThread.getResult() + sumThread.getResult() + sumPowThread.getResult();
            System.out.println("Result : " + s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new MultiThreadDemo();
    }
}
 // F1 = 1*2*3...*n  Tinh ham factorial
    class FacThread extends  Thread {
        long gt = 1;
        int n ;
        public FacThread(int k) {
            n = k;
        }

        @Override
        public void run() {

            for(int i  = 2; i <= n ; i++) {
                gt *= i;

            }
            System.out.println("F1 = "+gt);

        }
        public long getResult() {
            return gt;

        }
    }
    // F2 = 1+2+3 +.. n  ham tinh tong

    class SumThread extends Thread {
        long s = 0 ;
        int n ;
        public SumThread (int k ) {
             n = k;
        }

        @Override
        public void run() {

            for(int i = 1 ; i <= n ; i++) {
                s +=i ;
            }
            System.out.println("F2 = " + s);

        }

        public long getResult() {
            return s ;
        }
    }

    // f3  = x1^1 + x2^2 + ... xn^n

    class SumPowThread extends  Thread {
        long s = 0;
        int x,n;
        public SumPowThread(int y , int k ) {
            x = y;
            n = k;

        }
        @Override
        public void run() {

            for(int i = 1;i <= n ; i++) {
                s += Math.pow(x,i);
            }
            System.out.println("F3 = " + s);

        }
        public long getResult() {
            return s;
        }
    }
