package gui;

import scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMenu {

    private JFrame frame;
    private JPanel general, titlePanel, boxPanel,buttonPanel;
    private JLabel title, choice;
    private JComboBox<String> types;
    private JButton parameters,back;
    private Scene scene;
    private ImageIcon icon;

    private final int WIDTH=400,HEIGHT=220,GAP=10;
    private final float TITLE_FONT_SIZE_1 = 20.0f, NORMAL_FONT_SIZE=12.0f;
    private boolean boundingBoxState;

    public AddMenu(Scene scene,boolean bboxState)
    {
        this.scene=scene;
        icon = new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");
        boundingBoxState=bboxState;
        String[] itemTypes = scene.getTypes();
        types = new JComboBox<>(itemTypes);

        frame=new JFrame("Add a shape!");

        general=new JPanel();
        titlePanel=new JPanel();
        boxPanel=new JPanel();
        buttonPanel=new JPanel();

        title=new JLabel("Add");
        choice = new JLabel("Select a type of shape: ");

        parameters = new JButton("Parameters");
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
        boxPanel.add(types);
        choice.setFont(choice.getFont().deriveFont(NORMAL_FONT_SIZE));

        general.add(Box.createRigidArea(new Dimension(GAP,2*GAP)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2,4*GAP,0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(GAP,2*GAP,GAP,2*GAP));
        buttonPanel.add(parameters);
        buttonPanel.add(back);

        parameters.addActionListener(new AddMenu.ParametersButton());
        back.addActionListener(new AddMenu.BackButton());
    }

    private class ParametersButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String type = (String)types.getSelectedItem();
            if(type.equals("Complex item"))
            {
                AddComplex g = new AddComplex(scene,boundingBoxState);
                g.start();
            }
            else
            {
                AddShape g = new AddShape(scene,boundingBoxState,type);
                g.start();
            }
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
