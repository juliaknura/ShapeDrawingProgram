package item;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class TextItem extends Item{

    private String text;
    private int fontSize;
    private Point position;
    private int height;
    private int width;
    private boolean boundingBoxState;

    public TextItem(String name, String text, int fontSize, Point position)
    {
        super(name,null);
        this.text=text;
        this.fontSize=fontSize;
        this.position=position;
        boundingBoxState=false;
        initialBoundingBox();
    }


    @Override
    public void translate(Point p) {
        position.translate(p.getX(),p.getY());
        boundingBoxState=false;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setFont(new Font("Arial",Font.PLAIN,fontSize));
        calculateWidthAndHeight(g);
        calculateBoundingBox(g);
        g.drawString(text,position.getX(), position.getY());
    }

    private void calculateBoundingBox(Graphics2D g)
    {
        Point position2 = new Point(position.getX(), position.getY()+fontSize/3);
        Point topLeft = new Point(position2.getX(), position2.getY()-height);
        Point topRight = new Point(position2.getX()+width, position2.getY()-height);
        Point bottomLeft = position2;
        Point bottomRight = new Point(position2.getX()+width,position2.getY());
        setBox(new BoundingBox(topLeft,topRight,bottomLeft,bottomRight));
        boundingBoxState=true;
    }

    private void calculateWidthAndHeight(Graphics2D g)
    {
        Rectangle2D bounds = g.getFont().getStringBounds(text,g.getFontRenderContext());
        width = (int)Math.ceil(bounds.getWidth());
        height = (int)Math.ceil(bounds.getHeight());
    }

    private void initialBoundingBox()
    {
        setBox(new BoundingBox(position,position,position,position));
    }
}
