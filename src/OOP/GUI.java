package OOP;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI(String title) throws HeadlessException {
        super(title);
        initGUI() ;
    }
    public void initGUI(){
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);

        JPanel pnBoderLayout = new JPanel(new BorderLayout());
        JPanel pnNorths = new JPanel();

        this.add(pnBoderLayout);

    }
    public static void main(String[] args) {
        new GUI("Basic Caculator").setVisible(true);
    }

}
