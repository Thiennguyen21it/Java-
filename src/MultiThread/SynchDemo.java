package MultiThread;

    class  MyThread extends  Thread {
    int start ;
    public  MyThread( int s) {
        start = s ;

    }
    public static synchronized void go(int s) {
        for (int i = s ; i <10 ; i = i+2) {
            System.out.println(i + " ");
            try {
                Thread.sleep(100);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

        @Override
        public void run() {
             go(start);
        }
    }

    public class SynchDemo {
        public static void main(String[] args) {
            Thread t1 = new MyThread(1);
            Thread t2 = new MyThread(2);

            t1.start();
            t2.start();
        }

    }
