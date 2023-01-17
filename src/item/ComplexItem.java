package item;

import java.awt.*;
import java.util.ArrayList;

public class ComplexItem extends Item {
    private ArrayList<Item> children;

    public ComplexItem(String name,ArrayList<Item> children) {
        super(name,null);
        this.children=children;
        calculateBoundingBox();
    }

    @Override
    public void translate(Point p) {
        for(Item i:children)
        {
            i.translate(p);
        }
        calculateBoundingBox();
    }

    @Override
    public void draw(Graphics2D g) {
        for(Item i:children)
        {
            i.draw(g);
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
        int xMin=children.get(0).getPosition().getX(), xMax=children.get(0).getPosition().getX(), yMin=children.get(0).getPosition().getY(), yMax=children.get(0).getPosition().getY();

        for(Item i:children)
        {
            if(xMin>i.getPosition().getX())
            {
                xMin = i.getPosition().getX();
            }
            if(yMin>i.getPosition().getY())
            {
                yMin=i.getPosition().getY();
            }
            if(xMax<i.getBoundingBox().getBottomRight().getX())
            {
                xMax=i.getBoundingBox().getBottomRight().getX();
            }
            if(yMax<i.getBoundingBox().getBottomRight().getY())
            {
                yMax=i.getBoundingBox().getBottomRight().getY();
            }
        }

        Point topLeft = new Point(xMin,yMin);
        Point topRight = new Point(xMax,yMin);
        Point bottomLeft = new Point(xMin,yMax);
        Point bottomRight = new Point(xMax,yMax);

        setBox(new BoundingBox(topLeft,topRight,bottomLeft,bottomRight));
    }



}
