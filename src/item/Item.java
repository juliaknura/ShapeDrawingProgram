package item;

import java.awt.*;

public abstract class Item {
    private BoundingBox box;
    private String name;
    private Color color;

    public Item(String name,Color color)
    {
        this.name=name;
        this.color=color;
    }

    //returns the position of the top-left corner of the bounding box
    public Point getPosition()
    {
        return box.getTopLeft();
    }

    //function translating an item using a vector which begins in (0,0) and ends in p
    public abstract void translate(Point p);

    //returns the bounding box
    public BoundingBox getBoundingBox()
    {
        return box;
    }

    public abstract void draw(Graphics2D g);
    public abstract void drawBoundingBox(Graphics2D g);
    public void setBox(BoundingBox box) {
        this.box = box;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
