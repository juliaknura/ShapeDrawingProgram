package gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import scene.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    private Scene scene;
    private JFrame frame;
    private JLabel title1, title2, choiceLabel, addLabel, deleteLabel,moveLabel,boundingBoxLabel;
    private JButton addButton,deleteButton,moveButton,boundingBoxButton;
    private JPanel general, title, titleTitle, central, addPanel,deletePanel,movePanel,boundingBoxPanel,east,west,choicePanel;
    private ImagePanel pictureTitle1,pictureTitle2;
    private ImageIcon icon;
    private final int HEIGHT=410,WIDTH=700,SIDE_PANEL_WIDTH=50, TITLE_WIDTH=440,TITLE_HEIGHT=80,HORIZONTAL_GAP=20,VERTICAL_GAP=20, GAP=10;
    private final float TITLE_FONT_SIZE_1 = 28.0f,TITLE_FONT_SIZE_2 = 25.0f, NORMAL_FONT_SIZE=16.0f;

    public MainMenu(Scene scene)
    {
        this.scene=scene;
        icon = new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");

        frame= new JFrame("Shape-y shape-y shapes");

        title1 = new JLabel("SHAPE DRAWING");
        title2 = new JLabel("DRAW YOUR OWN SHAPE!");
        choiceLabel = new JLabel("Select your action");
        addLabel = new JLabel("Add an element");
        deleteLabel = new JLabel("Delete an element");
        moveLabel = new JLabel("Move an element");
        boundingBoxLabel = new JLabel("Manage bounding boxes:");

        pictureTitle1 = new ImagePanel();
        pictureTitle2 = new ImagePanel();

        addButton = new JButton("ADD");
        deleteButton = new JButton("DEL");
        moveButton = new JButton("MOV");
        boundingBoxButton = new JButton("GO");

        general = new JPanel();
        title = new JPanel();
        titleTitle = new JPanel();
        central = new JPanel();
        addPanel = new JPanel();
        deletePanel = new JPanel();
        movePanel = new JPanel();
        boundingBoxPanel = new JPanel();
        east = new JPanel();
        west = new JPanel();
        choicePanel = new JPanel();

    }

    public void start()
    {
        scene.draw();

        //main frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());

        //main frame layout
        frame.getContentPane().add(general, BorderLayout.CENTER);
        frame.getContentPane().add(east, BorderLayout.EAST);
        east.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH,HEIGHT));
        frame.getContentPane().add(west, BorderLayout.WEST);
        west.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH,HEIGHT));

        //general panel
        general.setLayout(new BoxLayout(general, BoxLayout.PAGE_AXIS));

        //title panel
        general.add(title);
        title.setLayout(new BoxLayout(title, BoxLayout.LINE_AXIS));
        title.add(pictureTitle1);
        title.add(titleTitle);
        title.add(pictureTitle2);
        title.setPreferredSize(new Dimension(WIDTH-2*SIDE_PANEL_WIDTH,TITLE_HEIGHT));
        title.setBorder(BorderFactory.createEmptyBorder(GAP,0,25,0));

        titleTitle.setLayout(new BoxLayout(titleTitle,BoxLayout.PAGE_AXIS));
        titleTitle.setPreferredSize(new Dimension(TITLE_WIDTH,TITLE_HEIGHT));

        titleTitle.add(title1);
        title1.setAlignmentX(Component.CENTER_ALIGNMENT);
        title1.setFont(title1.getFont().deriveFont(TITLE_FONT_SIZE_1));

        titleTitle.add(title2);
        title2.setAlignmentX(Component.CENTER_ALIGNMENT);
        title2.setFont(title2.getFont().deriveFont(TITLE_FONT_SIZE_2));

        JSeparator s = new JSeparator(SwingConstants.HORIZONTAL);
        s.setBackground(Color.BLACK);
        general.add(s);

        //choice panel
        general.add(choicePanel);

        choicePanel.add(choiceLabel);
        choiceLabel.setFont(choiceLabel.getFont().deriveFont(NORMAL_FONT_SIZE));
        choiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //central panel with buttons
        general.add(central);
        central.setLayout(new GridLayout(2,2,HORIZONTAL_GAP,VERTICAL_GAP));

        //add field
        central.add(addPanel);
        addPanel.setLayout(new BoxLayout(addPanel,BoxLayout.LINE_AXIS));
        addPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        addPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.DARK_GRAY));
        addPanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        addPanel.add(addButton);
        addPanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        addPanel.add(addLabel);

        addButton.addActionListener(new MainMenu.ReactAdd());

        //delete field
        central.add(deletePanel);
        deletePanel.setLayout(new BoxLayout(deletePanel,BoxLayout.LINE_AXIS));
        deletePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.DARK_GRAY));
        deletePanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        deletePanel.add(deleteButton);
        deletePanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        deletePanel.add(deleteLabel);

        deleteButton.addActionListener(new MainMenu.ReactDel());

        //bounding box field
        central.add(boundingBoxPanel);
        boundingBoxPanel.setLayout(new BoxLayout(boundingBoxPanel,BoxLayout.LINE_AXIS));
        boundingBoxPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        boundingBoxPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.DARK_GRAY));
        boundingBoxPanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        boundingBoxPanel.add(boundingBoxButton);
        boundingBoxPanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        boundingBoxPanel.add(boundingBoxLabel);

        boundingBoxButton.addActionListener(new MainMenu.ReactBB());

        //move field
        central.add(movePanel);
        movePanel.setLayout(new BoxLayout(movePanel,BoxLayout.LINE_AXIS));
        movePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.DARK_GRAY));
        movePanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        movePanel.add(moveButton);
        movePanel.add(Box.createRigidArea(new Dimension(GAP,GAP)));
        movePanel.add(moveLabel);

        moveButton.addActionListener(new MainMenu.ReactMov());

        general.add(Box.createRigidArea(new Dimension(GAP,3*GAP)));
    }

    private class ReactAdd implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddMenu g = new AddMenu(scene);
            g.start();
            frame.dispose();

        }
    }

    private class ReactDel implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteMenu g = new DeleteMenu(scene);
            g.start();
            frame.dispose();
        }
    }

    private class ReactMov implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            MoveMenu g = new MoveMenu(scene);
            g.start();
            frame.dispose();
        }
    }

    private class ReactBB implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            BoundingBoxMenu g = new BoundingBoxMenu(scene);
            g.start();
            frame.dispose();

        }
    }


}
