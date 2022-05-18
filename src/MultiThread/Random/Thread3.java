package MultiThread.Random;

public class Thread3 extends Thread {
    SharedData sharedData;

    public Thread3(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (sharedData.checkAvaible()) {
        synchronized (sharedData) {
            sharedData.notifyAll();
            try {

                while (true) {
                    if (sharedData.getIndex() != 3 && sharedData.checkAvaible()) {
                        break;
                    }
                    sharedData.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int rad = sharedData.getRad();
            if(rad %2==0) {
                if (rad %4==0) {
                    System.out.println("So ngau nhien chia het cho 4");

                }else {
                    System.out.println("So ngau nhien ko chia het cho 4");
                }
            }
        }
        }

    }
}
