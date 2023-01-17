package gui;

import item.*;
import item.Point;
import scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddShapeComplex {

    private JFrame frame;

    private JPanel general, titlePanel, buttonPanel, parametersPanel, msgPanel;
    private JLabel colorLabel, isFilledLabel, widthLabel, heightLabel, positionLabel, centerLabel, radiusLabel, textLabel, fontSizeLabel,
            aLabel,bLabel,cLabel,startLabel,endLabel,boundLabel,titleLabel,errMsg;
    private JTextField xField,yField,aX,bX,cX,aY,bY,cY,startX,startY,endX,endY,boundField,radiusField,widthField,heightField, textField;
    private JComboBox<String> colorBox,isFilledBox;
    private JComboBox<Integer> fontSize;
    private JButton add,back;

    private String type;
    private final Integer fonts[] = {10,11,12,14,16,20,24,32};
    private final String isFilledStates[] = {"filled","not filled"};
    private final String colors[] = {"red","black","blue","green"};
    private final String ERROR = "Given parameters are invalid!";
    private ImageIcon icon;
    private ArrayList<Item> items;

    private final int WIDTH=300, CIRCLE_HEIGHT=410, RECT_HEIGHT=450, TRI_HEIGHT=450,
            TEXT_HEIGHT=380, SEG_HEIGHT=380, SPIRAL_HEIGHT=380,GAP=10, SCENE_SIZE=500;

    private final float FONT_TITLE=20.0f;
    public AddShapeComplex(String type, ArrayList<Item> items)
    {
        icon = new ImageIcon("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png");
        this.items=items;
        this.type=type;

        frame=new JFrame("Add a shape to a complex shape!");
        general = new JPanel();
        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        parametersPanel = new JPanel();
        msgPanel = new JPanel();

        colorLabel= new JLabel("Select color:");
        isFilledLabel= new JLabel("Select if filled:");
        heightLabel= new JLabel("Insert height:");
        widthLabel= new JLabel("Insert width:");
        positionLabel= new JLabel("Insert position coordinates:");
        centerLabel= new JLabel("Insert center coordinates:");
        radiusLabel= new JLabel("Insert radius:");
        textLabel= new JLabel("Insert text:");
        fontSizeLabel= new JLabel("Select font size:");
        aLabel= new JLabel("Insert first point coordinates:");
        bLabel= new JLabel("Insert second point coordinates:");
        cLabel= new JLabel("Insert third point coordinates:");
        startLabel= new JLabel("Insert start point coordinates:");
        endLabel= new JLabel("Insert end point coordinates:");
        boundLabel= new JLabel("Insert bound:");
        errMsg= new JLabel("          ");

        xField = new JTextField("0");
        yField = new JTextField("0");
        aX = new JTextField("0");
        aY = new JTextField("0");
        bX = new JTextField("0");
        bY = new JTextField("0");
        cX = new JTextField("0");
        cY = new JTextField("0");
        startX = new JTextField("0");
        startY = new JTextField("0");
        endX = new JTextField("0");
        endY = new JTextField("0");
        boundField = new JTextField("0");
        radiusField = new JTextField("0");
        widthField = new JTextField("0");
        heightField = new JTextField("0");

        textField = new JTextField("insert text here");

        colorBox = new JComboBox<String>(colors);
        isFilledBox = new JComboBox<String>(isFilledStates);
        fontSize = new JComboBox<Integer>(fonts);

        add = new JButton("Add");
        back = new JButton("Back");
    }

    public void start()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
        switch(type)
        {
            case "Rectangle": rect();
                break;
            case "Circle": circle();
                break;
            case "Triangle": triangle();
                break;
            case "Segment": segment();
                break;
            case "Text": text();
                break;
            case "Spiral": spiral();
                break;
        }
    }
    private void rect()
    {
        titleLabel = new JLabel("Rectangle");
        frame.setSize(new Dimension(WIDTH,RECT_HEIGHT));

        frame.add(general);

        general.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
        general.setLayout(new BoxLayout(general,BoxLayout.PAGE_AXIS));

        //title
        general.add(titlePanel);
        titlePanel.add(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(FONT_TITLE));

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //parameters
        general.add(parametersPanel);
        parametersPanel.setLayout(new BoxLayout(parametersPanel,BoxLayout.PAGE_AXIS));

        parametersPanel.add(colorLabel);
        parametersPanel.add(colorBox);

        parametersPanel.add(isFilledLabel);
        parametersPanel.add(isFilledBox);

        parametersPanel.add(widthLabel);
        parametersPanel.add(widthField);

        parametersPanel.add(heightLabel);
        parametersPanel.add(heightField);

        parametersPanel.add(positionLabel);
        parametersPanel.add(xField);
        parametersPanel.add(yField);

        //msg panel
        general.add(msgPanel);
        msgPanel.add(errMsg);

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2,2*GAP,0));
        buttonPanel.add(add);
        buttonPanel.add(back);
        add.addActionListener(new AddShapeComplex.AddButton());
        back.addActionListener(new AddShapeComplex.BackButton());

    }

    private void circle()
    {
        titleLabel = new JLabel("Circle");
        frame.setSize(new Dimension(WIDTH,CIRCLE_HEIGHT));

        frame.add(general);

        general.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
        general.setLayout(new BoxLayout(general,BoxLayout.PAGE_AXIS));

        //title
        general.add(titlePanel);
        titlePanel.add(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(FONT_TITLE));

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //parameters
        general.add(parametersPanel);
        parametersPanel.setLayout(new BoxLayout(parametersPanel,BoxLayout.PAGE_AXIS));

        parametersPanel.add(colorLabel);
        parametersPanel.add(colorBox);

        parametersPanel.add(isFilledLabel);
        parametersPanel.add(isFilledBox);

        parametersPanel.add(radiusLabel);
        parametersPanel.add(radiusField);

        parametersPanel.add(centerLabel);
        parametersPanel.add(xField);
        parametersPanel.add(yField);

        //msg panel
        general.add(msgPanel);
        msgPanel.add(errMsg);

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2,2*GAP,0));
        buttonPanel.add(add);
        buttonPanel.add(back);
        add.addActionListener(new AddShapeComplex.AddButton());
        back.addActionListener(new AddShapeComplex.BackButton());
    }

    private void triangle()
    {
        titleLabel = new JLabel("Triangle");
        frame.setSize(new Dimension(WIDTH,TRI_HEIGHT));

        frame.add(general);

        general.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
        general.setLayout(new BoxLayout(general,BoxLayout.PAGE_AXIS));

        //title
        general.add(titlePanel);
        titlePanel.add(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(FONT_TITLE));

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //parameters
        general.add(parametersPanel);
        parametersPanel.setLayout(new BoxLayout(parametersPanel,BoxLayout.PAGE_AXIS));

        parametersPanel.add(colorLabel);
        parametersPanel.add(colorBox);

        parametersPanel.add(isFilledLabel);
        parametersPanel.add(isFilledBox);

        parametersPanel.add(aLabel);
        parametersPanel.add(aX);
        parametersPanel.add(aY);

        parametersPanel.add(bLabel);
        parametersPanel.add(bX);
        parametersPanel.add(bY);

        parametersPanel.add(cLabel);
        parametersPanel.add(cX);
        parametersPanel.add(cY);

        //msg panel
        general.add(msgPanel);
        msgPanel.add(errMsg);

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2,2*GAP,0));
        buttonPanel.add(add);
        buttonPanel.add(back);
        add.addActionListener(new AddShapeComplex.AddButton());
        back.addActionListener(new AddShapeComplex.BackButton());
    }

    private void segment()
    {
        titleLabel = new JLabel("Segment");
        frame.setSize(new Dimension(WIDTH,SEG_HEIGHT));

        frame.add(general);

        general.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
        general.setLayout(new BoxLayout(general,BoxLayout.PAGE_AXIS));

        //title
        general.add(titlePanel);
        titlePanel.add(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(FONT_TITLE));

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //parameters
        general.add(parametersPanel);
        parametersPanel.setLayout(new BoxLayout(parametersPanel,BoxLayout.PAGE_AXIS));

        parametersPanel.add(colorLabel);
        parametersPanel.add(colorBox);

        parametersPanel.add(startLabel);
        parametersPanel.add(startX);
        parametersPanel.add(startY);

        parametersPanel.add(endLabel);
        parametersPanel.add(endX);
        parametersPanel.add(endY);

        //msg panel
        general.add(msgPanel);
        msgPanel.add(errMsg);

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2,2*GAP,0));
        buttonPanel.add(add);
        buttonPanel.add(back);
        add.addActionListener(new AddShapeComplex.AddButton());
        back.addActionListener(new AddShapeComplex.BackButton());
    }

    private void text()
    {
        titleLabel = new JLabel("Text");
        frame.setSize(new Dimension(WIDTH,TEXT_HEIGHT));

        frame.add(general);

        general.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
        general.setLayout(new BoxLayout(general,BoxLayout.PAGE_AXIS));

        //title
        general.add(titlePanel);
        titlePanel.add(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(FONT_TITLE));

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //parameters
        general.add(parametersPanel);
        parametersPanel.setLayout(new BoxLayout(parametersPanel,BoxLayout.PAGE_AXIS));

        parametersPanel.add(fontSizeLabel);
        parametersPanel.add(fontSize);

        parametersPanel.add(textLabel);
        parametersPanel.add(textField);

        parametersPanel.add(positionLabel);
        parametersPanel.add(xField);
        parametersPanel.add(yField);

        //msg panel
        general.add(msgPanel);
        msgPanel.add(errMsg);

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2,2*GAP,0));
        buttonPanel.add(add);
        buttonPanel.add(back);
        add.addActionListener(new AddShapeComplex.AddButton());
        back.addActionListener(new AddShapeComplex.BackButton());
    }

    private void spiral()
    {
        titleLabel = new JLabel("Spiral");
        frame.setSize(new Dimension(WIDTH,SPIRAL_HEIGHT));

        frame.add(general);

        general.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
        general.setLayout(new BoxLayout(general,BoxLayout.PAGE_AXIS));

        //title
        general.add(titlePanel);
        titlePanel.add(titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(FONT_TITLE));

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //parameters
        general.add(parametersPanel);
        parametersPanel.setLayout(new BoxLayout(parametersPanel,BoxLayout.PAGE_AXIS));

        parametersPanel.add(colorLabel);
        parametersPanel.add(colorBox);

        parametersPanel.add(centerLabel);
        parametersPanel.add(xField);
        parametersPanel.add(yField);

        parametersPanel.add(boundLabel);
        parametersPanel.add(boundField);

        //msg panel
        general.add(msgPanel);
        msgPanel.add(errMsg);

        general.add(Box.createRigidArea(new Dimension(GAP,GAP)));

        //buttons
        general.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2,2*GAP,0));
        buttonPanel.add(add);
        buttonPanel.add(back);
        add.addActionListener(new AddShapeComplex.AddButton());
        back.addActionListener(new AddShapeComplex.BackButton());
    }

    private class AddButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(parametersCheck())
            {
                switch(type)
                {
                    case "Rectangle": rectAdd();
                        break;
                    case "Circle": circleAdd();
                        break;
                    case "Triangle": triangleAdd();
                        break;
                    case "Segment": segmentAdd();
                        break;
                    case "Text": textAdd();
                        break;
                    case "Spiral": spiralAdd();
                        break;
                }
                frame.dispose();
            }
            else
            {
                errMsg.setText(ERROR);
            }
        }
    }

    private class BackButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }

    private boolean parametersCheck()
    {
        boolean returned=true;
        switch(type)
        {
            case "Rectangle": returned=rectCheck();
                break;
            case "Circle": returned=circleCheck();
                break;
            case "Triangle": returned=triangleCheck();
                break;
            case "Segment": returned=segmentCheck();
                break;
            case "Text": returned=textCheck();
                break;
            case "Spiral": returned=spiralCheck();
                break;
        }
        return returned;
    }

    private boolean rectCheck()
    {
        if(Integer.parseInt(xField.getText())<0 || Integer.parseInt(xField.getText())>SCENE_SIZE || Integer.parseInt(yField.getText())<0 || Integer.parseInt(yField.getText())>SCENE_SIZE)
        {
            return false;
        }
        if(Integer.parseInt(heightField.getText())<0 || Integer.parseInt(widthField.getText())<0)
        {
            return false;
        }
        return true;
    }

    private boolean circleCheck()
    {
        if(Integer.parseInt(xField.getText())<0 || Integer.parseInt(xField.getText())>SCENE_SIZE || Integer.parseInt(yField.getText())<0 || Integer.parseInt(yField.getText())>SCENE_SIZE)
        {
            return false;
        }
        if(Integer.parseInt(radiusField.getText())<0)
        {
            return false;
        }
        return true;
    }

    private boolean triangleCheck()
    {
        if(Integer.parseInt(aX.getText())<0 || Integer.parseInt(aX.getText())>SCENE_SIZE || Integer.parseInt(aY.getText())<0 || Integer.parseInt(aY.getText())>SCENE_SIZE)
        {
            return false;
        }
        if(Integer.parseInt(bX.getText())<0 || Integer.parseInt(bX.getText())>SCENE_SIZE || Integer.parseInt(bY.getText())<0 || Integer.parseInt(bY.getText())>SCENE_SIZE)
        {
            return false;
        }
        if(Integer.parseInt(cX.getText())<0 || Integer.parseInt(cX.getText())>SCENE_SIZE || Integer.parseInt(cY.getText())<0 || Integer.parseInt(cY.getText())>SCENE_SIZE)
        {
            return false;
        }
        return true;
    }

    private boolean segmentCheck()
    {
        if(Integer.parseInt(startX.getText())<0 || Integer.parseInt(startX.getText())>SCENE_SIZE || Integer.parseInt(startY.getText())<0 || Integer.parseInt(startY.getText())>SCENE_SIZE)
        {
            return false;
        }
        if(Integer.parseInt(endX.getText())<0 || Integer.parseInt(endX.getText())>SCENE_SIZE || Integer.parseInt(endY.getText())<0 || Integer.parseInt(endY.getText())>SCENE_SIZE)
        {
            return false;
        }
        return true;
    }

    private boolean spiralCheck()
    {
        if(Integer.parseInt(xField.getText())<0 || Integer.parseInt(xField.getText())>SCENE_SIZE || Integer.parseInt(yField.getText())<0 || Integer.parseInt(yField.getText())>SCENE_SIZE)
        {
            return false;
        }
        if(Integer.parseInt(boundField.getText())<0)
        {
            return false;
        }
        return true;
    }

    private boolean textCheck()
    {
        if(Integer.parseInt(xField.getText())<0 || Integer.parseInt(xField.getText())>SCENE_SIZE || Integer.parseInt(yField.getText())<0 || Integer.parseInt(yField.getText())>SCENE_SIZE)
        {
            return false;
        }
        return true;
    }

    private void rectAdd()
    {
        Color color;
        switch ((String)colorBox.getSelectedItem())
        {
            case "red": color = Color.RED;
                break;
            case "black": color = Color.BLACK;
                break;
            case "green": color = Color.GREEN;
                break;
            case "blue": color = Color.BLUE;
                break;
            default: color = Color.BLACK;
                break;
        }
        boolean isFilled;
        switch ((String)isFilledBox.getSelectedItem())
        {
            case "filled": isFilled = true;
                break;
            case "not filled": isFilled = false;
                break;
            default: isFilled = false;
                break;
        }
        int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());

        items.add(new Rect(null,color,isFilled,width,height,new item.Point(x,y)));
    }

    private void circleAdd()
    {
        Color color;
        switch ((String)colorBox.getSelectedItem())
        {
            case "red": color = Color.RED;
                break;
            case "black": color = Color.BLACK;
                break;
            case "green": color = Color.GREEN;
                break;
            case "blue": color = Color.BLUE;
                break;
            default: color = Color.BLACK;
                break;
        }
        boolean isFilled;
        switch ((String)isFilledBox.getSelectedItem())
        {
            case "filled": isFilled = true;
                break;
            case "not filled": isFilled = false;
                break;
            default: isFilled = false;
                break;
        }
        int radius = Integer.parseInt(radiusField.getText());
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        items.add(new Circle(null,color,isFilled,new item.Point(x,y),radius));
    }

    private void triangleAdd()
    {
        Color color;
        switch ((String)colorBox.getSelectedItem())
        {
            case "red": color = Color.RED;
                break;
            case "black": color = Color.BLACK;
                break;
            case "green": color = Color.GREEN;
                break;
            case "blue": color = Color.BLUE;
                break;
            default: color = Color.BLACK;
                break;
        }
        boolean isFilled;
        switch ((String)isFilledBox.getSelectedItem())
        {
            case "filled": isFilled = true;
                break;
            case "not filled": isFilled = false;
                break;
            default: isFilled = false;
                break;
        }
        int ax = Integer.parseInt(aX.getText());
        int ay = Integer.parseInt(aY.getText());
        int bx = Integer.parseInt(bX.getText());
        int by = Integer.parseInt(bY.getText());
        int cx = Integer.parseInt(cX.getText());
        int cy = Integer.parseInt(cY.getText());
        items.add(new Triangle(null,color,isFilled,new item.Point(ax,ay),new item.Point(bx,by), new item.Point(cx,cy)));
    }

    private void segmentAdd()
    {
        Color color;
        switch ((String)colorBox.getSelectedItem())
        {
            case "red": color = Color.RED;
                break;
            case "black": color = Color.BLACK;
                break;
            case "green": color = Color.GREEN;
                break;
            case "blue": color = Color.BLUE;
                break;
            default: color = Color.BLACK;
                break;
        }
        int sx = Integer.parseInt(startX.getText());
        int sy = Integer.parseInt(startY.getText());
        int ex = Integer.parseInt(endX.getText());
        int ey = Integer.parseInt(endY.getText());
        items.add(new Segment(null,color,new item.Point(sx,sy), new item.Point(ex,ey)));
    }

    private void spiralAdd()
    {
        Color color;
        switch ((String)colorBox.getSelectedItem())
        {
            case "red": color = Color.RED;
                break;
            case "black": color = Color.BLACK;
                break;
            case "green": color = Color.GREEN;
                break;
            case "blue": color = Color.BLUE;
                break;
            default: color = Color.BLACK;
                break;
        }
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        int bound = Integer.parseInt(boundField.getText());
        items.add(new Spiral(null,color,new item.Point(x,y),bound));
    }

    private void textAdd()
    {
        String text = textField.getText();
        int font = (int)fontSize.getSelectedItem();
        int x = Integer.parseInt(xField.getText());
        int y = Integer.parseInt(yField.getText());
        items.add(new TextItem(null,text,font,new Point(x,y)));
    }
}
