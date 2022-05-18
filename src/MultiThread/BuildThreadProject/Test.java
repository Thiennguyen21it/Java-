package MultiThread.BuildThreadProject;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static MyBank myBank = new MyBank(1000);
    public static void main(String[] args) {
        List<WitDrawThread> witDrawThreads = new ArrayList<>();
        for (int i= 0 ; i<= 100 ; i++) {
            witDrawThreads.add(new WitDrawThread(myBank,"T" +i));
        }
        for (WitDrawThread itDrawThread : witDrawThreads
             ) {
            itDrawThread.start();
        }

    }
}
