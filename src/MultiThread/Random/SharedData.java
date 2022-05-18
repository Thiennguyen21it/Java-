package MultiThread.Random;

public class SharedData {
    int rad;
    int total;
    int index;
    //index  = 1,2,3
//  1 => thread 1
//    2 = > thread 2
    public SharedData() {
        total = 0;
        index = 1;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public synchronized void plus(int value) {
        total += value;
    }
    public synchronized boolean checkAvaible() {
        return  total < 200;
    }


}
