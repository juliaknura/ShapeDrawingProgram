package gui;

import item.ComplexItem;
import item.Item;
import scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddComplex {

    private JFrame frame;
    private JPanel general, titlePanel, paramPanel, msgPanel, buttonPanel, namePanel;
    private JLabel title, nameLabel, typeLabel, msgLabel;
    private JButton finish, add, back;
    private JTextField nameField;
    private JComboBox<String> types;
    private Scene scene;
    private ImageIcon icon;
    private boolean boundingBoxState;
    private ArrayList<Item> list;

    private final String ERROR = "Invalid parameters!";
    private final int WIDTH=400, HEIGHT=265, GAP=10;
    private final float TITLE_FONT_SIZE_1 = 20.0f, NORMAL_FONT_SIZE=12.0f;

    public AddComplex(Scene scene,boolean bboxState)
    {
        this.scene=scene;
        icon = new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");
        boundingBoxState=bboxState;
        list = new ArrayList<Item>();

        frame=new JFrame("Add a complex shape!");
        general = new JPanel();
        titlePanel = new JPanel();
        paramPanel = new JPanel();
        msgPanel = new JPanel();
        buttonPanel = new JPanel();
        namePanel = new JPanel();

        title = new JLabel("Complex item");
        nameLabel = new JLabel("Insert name:");
        typeLabel = new JLabel("Select a type of element to ");
        msgLabel = new JLabel("           ");

        nameField = new JTextField();

        finish = new JButton("Finish");
        add = new JButton("Add");
        back = new JButton("Back");

        types = new JComboBox<>(scene.getBasicTypes());
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

        //name
        general.add(namePanel);
        namePanel.setLayout(new BoxLayout(namePanel,BoxLayout.LINE_AXIS));
        namePanel.add(nameLabel);
        namePanel.add(Box.createRigidArea(new Dimension(4*GAP,GAP)));
        namePanel.add(nameField);
        nameLabel.setFont(nameLabel.getFont().deriveFont(NORMAL_FONT_SIZE));

        general.add(Box.createRigidArea(new Dimension(GAP,2*GAP)));

        //box
        general.add(paramPanel);
        paramPanel.setLayout(new BoxLayout(paramPanel,BoxLayout.LINE_AXIS));
        paramPanel.add(typeLabel);
        paramPanel.add(Box.createRigidArea(new Dimension(4*GAP,GAP)));
        paramPanel.add(types);
        typeLabel.setFont(typeLabel.getFont().deriveFont(NORMAL_FONT_SIZE));

        general.add(Box.createRigidArea(new Dimension(GAP,5)));
        //msg
        general.add(msgPanel);
        msgPanel.add(msgLabel);
        msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        general.add(Box.createRigidArea(new Dimension(GAP,5)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,3,2*GAP,0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(GAP,2*GAP,GAP,2*GAP));
        buttonPanel.add(finish);
        buttonPanel.add(add);
        buttonPanel.add(back);

        finish.addActionListener(new AddComplex.Finish());
        add.addActionListener(new AddComplex.AddShapeButton());
        back.addActionListener(new AddComplex.BackButton());


    }

    private class BackButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddMenu g = new AddMenu(scene,boundingBoxState);
            g.start();
            frame.dispose();
        }
    }

    private class AddShapeButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String type = (String)types.getSelectedItem();
            AddShapeComplex g = new AddShapeComplex(type,list);
            g.start();
        }
    }

    private class Finish implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(checkParameters())
            {
                scene.addItem(new ComplexItem(nameField.getText(),list));
                scene.draw(boundingBoxState);
                AddMenu g = new AddMenu(scene,boundingBoxState);
                g.start();
                frame.dispose();
            }
            else
            {
                msgLabel.setText(ERROR);
            }


        }
    }

    private boolean checkParameters()
    {
        return scene.checkIfNameAlreadyExists(nameField.getText());
    }
}
