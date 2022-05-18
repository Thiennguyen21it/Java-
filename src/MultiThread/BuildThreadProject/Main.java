package MultiThread.BuildThreadProject;

public class Main {
    public static void main(String[] args) {
        //luồng chính (MAIN THREAD )
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {  // run khi t1.start() khoi chay

            }
        });
        t1.start();

        // main thread
        for (int i = 0; i < 10 ; i++) {
        }
    }
}
