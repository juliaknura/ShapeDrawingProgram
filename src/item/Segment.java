package item;

import java.awt.*;

public class Segment extends Primitive{

    private Point start,end;
    private double length;

    public Segment(String name, Color color,Point start, Point end) {
        super(name,color);
        this.start=start;
        this.end=end;
        calculateBoundingBox();
        calculateLength();
    }

    @Override
    public void translate(Point p) {
        start.translate(p.getX(),p.getY());
        end.translate(p.getX(), p.getY());
        calculateBoundingBox();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

    @Override
    public void drawBoundingBox(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10f,new float[]{9},5f));
        g.drawRect(getPosition().getX(),getPosition().getY(),getBoundingBox().getTopRight().getX()-getBoundingBox().getTopLeft().getX(),getBoundingBox().getBottomLeft().getY()-getBoundingBox().getTopLeft().getY());
    }

    private void calculateBoundingBox()
    {
        int maxX,maxY,minX,minY;
        maxX=Math.max(start.getX(), end.getX());
        minX=Math.min(start.getX(), end.getX());
        maxY=Math.max(start.getY(), end.getY());
        minY=Math.min(start.getY(), end.getY());

        Point topLeft = new Point(minX,minY);
        Point topRight = new Point(maxX,minY);
        Point bottomLeft = new Point(minX,maxY);
        Point bottomRight = new Point(maxX,maxY);

        setBox(new BoundingBox(topLeft,topRight,bottomLeft,bottomRight));
    }

    private void calculateLength()
    {
        length=Math.sqrt((start.getX()-end.getX())^2+(start.getY()-end.getY())^2);
    }
}
