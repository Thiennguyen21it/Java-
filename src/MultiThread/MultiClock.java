package MultiThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MultiClock extends JFrame implements ActionListener,Runnable {
    JButton createClock  = new JButton("New Clock");
    JLabel clock = new JLabel();

    Thread t;
    public  MultiClock() {
        Container cont = this.getContentPane();
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        clock = new JLabel(sdf.format(cal.getTime()),JLabel.CENTER);

        clock.setFont(new Font(clock.getFont().getName(),Font.PLAIN,40));
        clock.setForeground(Color.RED);
        cont.add(createClock,"North");
        cont.add(clock);
        this.pack();
        this.setVisible(true);
        createClock.addActionListener(this);
        Thread t = new Thread(this);
        t.start();

    }
        public void tick(){
        try{
            Calendar cal  = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            clock.setText(sdf.format(cal.getTime()));
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
       }

    @Override
    public void actionPerformed(ActionEvent e) {
            Thread t = new Thread(new MultiClock());
            t.start();
    }

    public static void main(String[] args) {
        new MultiClock();
    }
    @Override
    public void run() {
        while(true) {
            tick();
        }
    }
}
