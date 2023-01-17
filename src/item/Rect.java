package item;

import java.awt.*;

public class Rect extends Shape{

    private int width, height;
    private Point position;

    public Rect(String name, Color color, boolean isFilled, int width, int height, Point position) {
        super(name,color,isFilled);
        this.width=width;
        this.height=height;
        this.position=position;
        calculateBoundingBox();
    }


    @Override
    public void translate(Point p) {
        position.translate(p.getX(),p.getY());
        calculateBoundingBox();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        if(getFilled()) {
            g.fillRect(position.getX(), position.getY(), width, height);
        }
        else
        {
            g.drawRect(position.getX(), position.getY(), width, height);
        }
    }

    @Override
    public void drawBoundingBox(Graphics2D g) {
        g.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10f,new float[]{9},5f));
        g.setColor(Color.DARK_GRAY);
        g.drawRect(position.getX(),position.getY(),width,height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void calculateBoundingBox()
    {
        Point topLeft = position;
        Point topRight = new Point(position.getX()+width, position.getY());
        Point bottomLeft = new Point(position.getX(), position.getY()+height);
        Point bottomRight = new Point(position.getX()+width,position.getY()+height);
        setBox(new BoundingBox(topLeft,topRight,bottomLeft,bottomRight));
    }

}
