package scene;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import item.*;

public class MyFrame extends JFrame {

    private MyPanel panel;
    private ImageIcon icon;

    public void create(ArrayList<Item> items)
    {
        if(panel!=null) {
            this.remove(panel);
        }
        icon = new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");
        panel = new MyPanel(items);
        panel.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setIconImage(icon.getImage());

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
