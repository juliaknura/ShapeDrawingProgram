package gui;

import item.Item;
import scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMenu {

    private JFrame frame;
    private JPanel general, titlePanel, boxPanel,deleteAndBackPanel;
    private JLabel title, choice;
    private JComboBox<String> items;
    private JButton delete,back;
    private Scene scene;
    private ImageIcon icon;

    private boolean boundingBoxState;
    private final int WIDTH=400,HEIGHT=220,GAP=10;
    private final float TITLE_FONT_SIZE_1 = 20.0f, NORMAL_FONT_SIZE=12.0f;

    public DeleteMenu(Scene scene,boolean bboxState)
    {
        this.scene=scene;
        icon=new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");
        boundingBoxState=bboxState;
        items=new JComboBox<String>(scene.itemNames());

        frame=new JFrame("Delete a shape!");

        general=new JPanel();
        titlePanel=new JPanel();
        boxPanel=new JPanel();
        deleteAndBackPanel=new JPanel();

        title=new JLabel("Delete");
        choice = new JLabel("Select a shape to delete: ");

        delete = new JButton("Delete");
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
        general.add(deleteAndBackPanel);
        deleteAndBackPanel.setLayout(new GridLayout(1,2,4*GAP,0));
        deleteAndBackPanel.setBorder(BorderFactory.createEmptyBorder(GAP,4*GAP,GAP,4*GAP));
        deleteAndBackPanel.add(delete);
        deleteAndBackPanel.add(back);

        delete.addActionListener(new DeleteMenu.DeleteButton());
        back.addActionListener(new DeleteMenu.BackButton());

    }

    private class DeleteButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Item i = scene.getItem((String)items.getSelectedItem());
            scene.deleteItem(i.getName());
            scene.draw(boundingBoxState);
            DeleteMenu g = new DeleteMenu(scene,boundingBoxState);
            g.start();
            frame.dispose();
        }
    }

    private class BackButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainMenu g = new MainMenu(scene,boundingBoxState);
            g.start();
            frame.dispose();
        }
    }
}
