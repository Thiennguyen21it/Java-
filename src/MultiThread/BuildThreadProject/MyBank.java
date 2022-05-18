package MultiThread.BuildThreadProject;

public class MyBank {
    int money ;
    public MyBank() {

    }
    public MyBank(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public synchronized   void  DrawMoney(int money, String Threadname) {
        if(money <= this.money) {
            System.out.println("So tien rut" + money +"Thread : " + Threadname);
            this.money -= money;
        }else {
            System.out.println("So tien rut vuot qua so tien rut hien tai ");
        }
    }

}
