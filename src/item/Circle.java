package item;

import java.awt.*;

public class Circle extends Shape{

    private int radius;
    private Point falsecenter;

    public Circle(String name, Color color,boolean isFilled,Point center, int radius) {
        super(name,color,isFilled);
        this.radius=radius;
        this.falsecenter=new Point(center.getX()-radius,center.getY()-radius);
        calculateBoundingBox();
    }


    @Override
    public void translate(Point p) {
        falsecenter.translate(p.getX(),p.getY());
        calculateBoundingBox();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        if(getFilled())
        {
            g.fillOval(falsecenter.getX(), falsecenter.getY(), 2*radius,2*radius);
        }
        else {
            g.drawOval(falsecenter.getX(), falsecenter.getY(), 2*radius,2*radius);
        }
    }

    @Override
    public void drawBoundingBox(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10f,new float[]{9},5f));
        g.drawRect(falsecenter.getX(), falsecenter.getY(),2*radius,2*radius);
    }

    public int getRadius() {
        return radius;
    }

    private void calculateBoundingBox()
    {
        Point topLeft = falsecenter;
        Point topRight = new Point(falsecenter.getX()+2*radius,falsecenter.getY());
        Point bottomLeft = new Point(falsecenter.getX(),falsecenter.getY()+2*radius);
        Point bottomRight = new Point(falsecenter.getX()+2*radius,falsecenter.getY()+2*radius);
        setBox(new BoundingBox(topLeft,topRight,bottomLeft,bottomRight));
    }
}
