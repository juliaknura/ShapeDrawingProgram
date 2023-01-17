package scene;

import javax.swing.*;
import item.*;

import java.awt.*;
import java.util.*;

public class MyPanel extends JPanel {

    private final int SIZE=500;
    private final int GAP_SIZE=10;
    private ArrayList<Item> items;

    public MyPanel(ArrayList<Item> items)
    {
        this.setPreferredSize(new Dimension(SIZE,SIZE));
        this.items=items;
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        //drawing a grid
        g2d.setStroke(new BasicStroke(0.5f));
        g2d.setColor(Color.LIGHT_GRAY);
        for(int i=GAP_SIZE;i<SIZE;i+=GAP_SIZE)
        {
            g2d.drawLine(i,0,i,SIZE);
            g2d.drawLine(0,i,SIZE,i);
        }

        //settings for default items
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));

        //drawing items
        for(Item i:items)
        {
            i.draw(g2d);
        }
    }
}
