package gui;

import item.Decoration;
import item.Item;
import scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoundingBoxMenu {

    private JFrame frame;
    private JPanel general, titlePanel, boxPanel,BBAndBackPanel;
    private JLabel title, choice;
    private JComboBox<String> items;
    private JButton bb,back;
    private Scene scene;
    private ImageIcon icon;
    private final int WIDTH=400,HEIGHT=220,GAP=10;
    private final float TITLE_FONT_SIZE_1 = 20.0f, NORMAL_FONT_SIZE=12.0f;

    public BoundingBoxMenu(Scene scene)
    {
        this.scene=scene;
        icon=new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");

        items=new JComboBox<String>(scene.itemNames());

        frame=new JFrame("Select a shape!");

        general=new JPanel();
        titlePanel=new JPanel();
        boxPanel=new JPanel();
        BBAndBackPanel=new JPanel();

        title=new JLabel("Select");
        choice = new JLabel("Select a shape: ");

        bb = new JButton("Select/unselect");
        back = new JButton("Back");
    }

    public void start()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
        frame.setSize(new Dimension(WIDTH,HEIGHT));

        frame.add(general);

        general.setLayout(new BoxLayout(general,BoxLayout.PAGE_AXIS));
        general.setBorder(BorderFactory.createEmptyBorder(GAP,4*GAP,GAP,4*GAP));

        //title
        general.add(titlePanel);

        titlePanel.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(title.getFont().deriveFont(TITLE_FONT_SIZE_1));

        general.add(Box.createRigidArea(new Dimension(GAP,3*GAP)));

        //box
        general.add(boxPanel);
        boxPanel.setLayout(new BoxLayout(boxPanel,BoxLayout.LINE_AXIS));
        boxPanel.add(choice);
        boxPanel.add(Box.createRigidArea(new Dimension(4*GAP,GAP)));
        boxPanel.add(items);
        choice.setFont(choice.getFont().deriveFont(NORMAL_FONT_SIZE));

        general.add(Box.createRigidArea(new Dimension(GAP,2*GAP)));

        //buttons
        general.add(BBAndBackPanel);
        BBAndBackPanel.setLayout(new GridLayout(1,2,4*GAP,0));
        BBAndBackPanel.setBorder(BorderFactory.createEmptyBorder(GAP,4*GAP,GAP,4*GAP));
        BBAndBackPanel.add(bb);
        BBAndBackPanel.add(back);

        bb.addActionListener(new BoundingBoxMenu.BBButton());
        back.addActionListener(new BoundingBoxMenu.BackButton());

    }

    private class BBButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Item i = scene.getItem((String)items.getSelectedItem());
            Item newItem;
            if(i instanceof Decoration)
            {
                newItem= ((Decoration) i).getItem();

            }
            else
            {
                newItem = new Decoration(i);

            }
            scene.deleteItem((String)items.getSelectedItem());
            scene.addItem(newItem);
            scene.draw();
        }
    }

    private class BackButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu g = new MainMenu(scene);
            g.start();
            frame.dispose();
        }
    }

}
