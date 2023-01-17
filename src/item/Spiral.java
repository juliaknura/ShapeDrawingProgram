package item;

import java.awt.*;

public class Spiral extends Shape{

    private Point center;
    private Point bound;
    private int gap,boundInt;
    private final int DIFFERENCE=1;
    private final int ANGLE_CHANGE=15;

    public Spiral(String name, Color color, Point center, int bound) {
        super(name, color, false);
        this.center=center;
        boundInt=bound;
        this.bound=new Point(center.getX()-bound, center.getY()-bound);
        gap=bound;
        calculateBoundingBox();
    }

    @Override
    public void translate(Point p) {
        center.translate(p.getX(),p.getY());
        bound = new Point(center.getX()-boundInt, center.getY()-boundInt);
        calculateBoundingBox();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        int x=center.getX();
        int y=center.getY();
        int gap=DIFFERENCE;
        int startingAngle=0;
        int angleChange=ANGLE_CHANGE;
        while(x> bound.getX() && y>bound.getY())
        {
            g.drawArc(x,y,gap,gap,startingAngle,angleChange);
            x-=DIFFERENCE;
            y-=DIFFERENCE;
            gap+=2*DIFFERENCE;
            startingAngle+=angleChange;
        }
    }

    @Override
    public void drawBoundingBox(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10f,new float[]{9},5f));
        g.drawRect(bound.getX(), bound.getY(), 2*gap,2*gap);
    }

    private void calculateBoundingBox()
    {
        Point topLeft = bound;
        Point topRight = new Point(bound.getX()+2*gap,bound.getY());
        Point bottomLeft = new Point(bound.getX(), bound.getY()+2*gap);
        Point bottomRight = new Point(bound.getX()+2*gap,bound.getY()+2*gap);
        setBox(new BoundingBox(topLeft,topRight,bottomLeft,bottomRight));
    }
}
