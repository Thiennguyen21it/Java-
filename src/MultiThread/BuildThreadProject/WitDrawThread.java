package MultiThread.BuildThreadProject;

public class WitDrawThread extends  Thread {
    MyBank myBank ;
    String name;

    public WitDrawThread(MyBank myBank, String name) {
        this.name = name;
        this.myBank = myBank;
    }

    @Override
    public void run() {
            myBank.DrawMoney(800,name);
    }
}
