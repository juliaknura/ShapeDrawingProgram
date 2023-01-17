package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private Image image;
    private final int SIZE=80;

    public ImagePanel() {
        super();
        try {
            image = ImageIO.read(new File("C:\\Users\\julia\\IdeaProjects\\Lista8pp\\src\\shapes.png"));
            image.getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);
        } catch(IOException e) {image=null;};
        this.setPreferredSize(new Dimension(SIZE,SIZE));
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawImage(image,0,0,null);
        repaint();
    }

}
