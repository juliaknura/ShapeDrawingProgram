package gui;

import item.Item;
import item.Point;
import scene.Scene;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveMenu {

    private JFrame frame;
    private JPanel general, titlePanel, boxPanel, coordPanel, msgPanel,movePanel;
    private JComboBox<String> items;
    private JLabel title,boxMsg,coordMsg,xLab,yLab,errorMsg;
    private JTextField xField, yField;
    private JButton move, back;
    private Scene scene;
    private final int SCENE_SIZE=500,HEIGHT=310,WIDTH=500,GAP=10;
    private final float TITLE_FONT_SIZE_1 = 20.0f, NORMAL_FONT_SIZE=12.0f;
    private final String ERR_MSG = "Cannot move an element beyond the scene dumbo";
    private ImageIcon icon;
    private boolean boundingBoxState;
    private int x,y;

    public MoveMenu(Scene scene, boolean bboxState)
    {
        this.scene=scene;
        icon = new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");
        boundingBoxState=bboxState;

        frame = new JFrame("Move a shape!");

        general = new JPanel();
        titlePanel = new JPanel();
        boxPanel = new JPanel();
        coordPanel = new JPanel();
        msgPanel = new JPanel();
        movePanel = new JPanel();

        items = new JComboBox<String>(scene.itemNames());

        title = new JLabel("Move by a vector [0,0 ; x,y]");
        boxMsg = new JLabel("Select an element to move:");
        coordMsg = new JLabel("Insert point coordinates:");
        xLab = new JLabel("x: ");
        yLab = new JLabel("y: ");
        errorMsg = new JLabel("             ");

        move = new JButton("Move");
        back = new JButton("Back");

        xField=new JTextField("0");
        yField=new JTextField("0");
    }

    public void start()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(new Dimension(WIDTH,HEIGHT));
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout());


        frame.add(general,BorderLayout.CENTER);

        general.setBorder(BorderFactory.createEmptyBorder(2*GAP,2*GAP,2*GAP,2*GAP));
        general.setLayout(new BoxLayout(general, BoxLayout.PAGE_AXIS));
        general.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        general.add(titlePanel);

        //title
        titlePanel.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(title.getFont().deriveFont(TITLE_FONT_SIZE_1));

        general.add(Box.createRigidArea(new Dimension(GAP,2*GAP)));

        //combo box panel
        general.add(boxPanel);
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.LINE_AXIS));
        boxPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        boxPanel.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));

        boxPanel.add(items);
        items.setPreferredSize(new Dimension(20*GAP,2*GAP));
        boxPanel.add(Box.createRigidArea(new Dimension(6*GAP,GAP)));
        boxPanel.add(boxMsg);
        boxMsg.setFont(boxMsg.getFont().deriveFont(NORMAL_FONT_SIZE));

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //coordinates panel
        general.add(coordPanel);
        coordPanel.setLayout(new BoxLayout(coordPanel, BoxLayout.LINE_AXIS));
        coordPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        coordPanel.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,2*GAP,GAP));

        coordPanel.add(yField);
        coordPanel.add(yLab);
        yLab.setFont( yLab.getFont().deriveFont(NORMAL_FONT_SIZE));
        coordPanel.add(Box.createRigidArea(new Dimension(GAP,2*GAP)));
        coordPanel.add(xField);
        coordPanel.add(xLab);
        xLab.setFont( xLab.getFont().deriveFont(NORMAL_FONT_SIZE));

        coordPanel.add(Box.createRigidArea(new Dimension(6*GAP,GAP)));
        coordPanel.add(coordMsg);
        coordMsg.setFont(coordMsg.getFont().deriveFont(NORMAL_FONT_SIZE));

        //msg
        general.add(msgPanel);
        //msgPanel.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,0,GAP));
        msgPanel.add(errorMsg);
        errorMsg.setAlignmentX(Component.CENTER_ALIGNMENT);

        //buttons
        general.add(movePanel);
        movePanel.setBorder(BorderFactory.createEmptyBorder(GAP,4*GAP,GAP,4*GAP));
        movePanel.setLayout(new GridLayout(1,2,4*GAP,0));
        movePanel.add(move);
        movePanel.add(back);
        move.addActionListener(new MoveMenu.MoveButton());
        back.addActionListener(new MoveMenu.BackButton());

    }

    private class MoveButton implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
            Item i = scene.getItem((String)items.getSelectedItem());
            if(coordinatesCheck(i))
            {
                scene.getItem(i.getName()).translate(new Point(x,y));
                errorMsg.setText("           ");

            }
            else {
                errorMsg.setText(ERR_MSG);
            }
            scene.draw(boundingBoxState);

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

    private boolean coordinatesCheck(Item i)
    {
        if(i.getPosition().getX()+x<0 || i.getPosition().getX()+x>SCENE_SIZE || i.getPosition().getY()+y<0 || i.getPosition().getY()+y>SCENE_SIZE)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
