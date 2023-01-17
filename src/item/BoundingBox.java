package item;

import java.awt.*;

public class BoundingBox {
    private Point topLeft, topRight, bottomLeft, bottomRight;

    public BoundingBox() {
        topLeft=topRight=bottomRight=bottomLeft=new Point();
    }

    public BoundingBox(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public void draw(Graphics2D g)
    {
        g.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10f,new float[]{9},5f));
        g.setColor(Color.DARK_GRAY);
        g.drawRect(topLeft.getX(),topLeft.getY(), topRight.getX()-topLeft.getX(), bottomLeft.getY()-topLeft.getY());
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));
    }
}
