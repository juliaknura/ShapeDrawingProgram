package item;

import java.awt.*;

public class Decoration extends Item{

    private Item item;

    public Decoration(Item item) {
        super(item.name, item.color);
        this.item=item;
    }

    @Override
    public void translate(Point p) {
        item.translate(p);
    }

    @Override
    public void draw(Graphics2D g) {
        item.draw(g);
        item.getBoundingBox().draw(g);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Point getPosition()
    {
        return item.box.getTopLeft();
    }

    public BoundingBox getBoundingBox()
    {
        return item.box;
    }
}
