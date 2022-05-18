package MultiThread.Random;

public class Thread2 extends Thread {
    SharedData sharedData;

    public Thread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (sharedData.checkAvaible()) {
            synchronized (sharedData) {
                sharedData.notifyAll();
                try {

                    while (true) {
                        if (sharedData.getIndex() != 2 && sharedData.checkAvaible()) {
                            break;
                        }
                        sharedData.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int rad = sharedData.getRad();
                if (rad %3 == 0) {
                    rad *= rad;
                    System.out.println("T2 >>" +rad);
                }
            }
        }
    }
}