package item;

import java.awt.*;

public class Triangle extends Shape{

    private Point a,b,c;
    private final int NO_OF_SIDES=3;

    public Triangle(String name,Color color,boolean isFilled, Point a, Point b, Point c) {
        super(name,color,isFilled);
        this.a=a;
        this.b=b;
        this.c=c;
        calculateBoundingBox();
    }


    @Override
    public void translate(Point p) {
        a.translate(p.getX(),p.getY());
        b.translate(p.getX(),p.getY());
        c.translate(p.getX(),p.getY());
        calculateBoundingBox();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        int[] xs = new int[NO_OF_SIDES];
        xs[0]=a.getX();
        xs[1]=b.getX();
        xs[2]=c.getX();

        int[] ys = new int[NO_OF_SIDES];
        ys[0]=a.getY();
        ys[1]=b.getY();
        ys[2]=c.getY();
        if(getFilled())
        {
            g.fillPolygon(xs,ys,NO_OF_SIDES);
        }
        else {
            g.drawPolygon(xs,ys,NO_OF_SIDES);
        }
    }

    @Override
    public void drawBoundingBox(Graphics2D g) {
        g.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10f,new float[]{9},5f));
        g.setColor(Color.DARK_GRAY);
        g.drawRect(getPosition().getX(),getPosition().getY(),getBoundingBox().getTopRight().getX()-getBoundingBox().getTopLeft().getX(),getBoundingBox().getBottomLeft().getY()-getBoundingBox().getTopLeft().getY());
    }

    private void calculateBoundingBox()
    {
        int maxX,minX,maxY,minY;

        minX = Math.min(Math.min(c.getX(),b.getX()),a.getX());
        minY = Math.min(Math.min(c.getY(),b.getY()),a.getY());
        maxX = Math.max(Math.max(c.getX(),b.getX()),a.getX());
        maxY = Math.max(Math.max(c.getY(),b.getY()),a.getY());

        Point topLeft = new Point(minX,minY);
        Point topRight = new Point(maxX,minY);
        Point bottomLeft = new Point(minX,maxY);
        Point bottomRight = new Point(maxX,maxY);

        setBox(new BoundingBox(topLeft,topRight,bottomLeft,bottomRight));
    }
}
