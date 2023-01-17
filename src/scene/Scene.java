package scene;
import item.*;

import java.util.ArrayList;
import java.awt.*;
import item.Point;

public class Scene {

    private ArrayList<Item> items;
    private MyFrame frame;
    private final int NO_TYPES=7;

    public Scene()
    {
        items=new ArrayList<Item>();
        frame = new MyFrame();
        defaultStart();
    }

    public Scene(ArrayList<Item> items)
    {
        this.items=items;
        frame = new MyFrame();
    }

    public void draw(boolean boundingBox) {
        frame.create(items,boundingBox);
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void deleteItem(String name)
    {
        for(int i=0;i<items.size();i++)
        {
            if(items.get(i).getName().equals(name))
            {
                items.remove(i);
                return;
            }
        }
    }

    public Item getItem(String name)
    {
        for(int i=0;i<items.size();i++)
        {
            if(items.get(i).getName().equals(name))
            {
                return items.get(i);
            }
        }
        return null;
    }

//    public void changeSomething()
//    {
//        for(Item i:items)
//        {
//           i.translate(new Point(40,40));
//       }
//    }

    public void defaultStart()
    {
        ArrayList<Item> children = new ArrayList<Item>();
        children.add(new Circle(null,Color.BLACK,false,new Point(400,100),30));
        children.add(new Circle(null,Color.BLACK,false,new Point(400,180),50));
        children.add(new Circle(null,Color.BLACK,false,new Point(400,300),70));
        children.add(new Circle(null,Color.BLACK,false,new Point(390,100),5));
        children.add(new Circle(null,Color.BLACK,false,new Point(410,100),5));
        children.add(new TextItem(null,"bawlan :)",14,new Point(390,310)));
        items.add(new ComplexItem("bawlan",children));

        items.add(new TextItem("text1","przykladowy tekst",14,new Point(20,450)));
        items.add(new Segment("segment1",Color.RED,new Point(80,293),new Point(130,153)));
        items.add(new Rect("rectangle1",Color.BLUE,true,29,39,new Point(11,11)));
        items.add(new Triangle("triangle1",Color.GREEN,true,new Point(240,200),new Point(300,220),new Point(280,270)));
        items.add(new Spiral("spiral1",Color.BLACK,new Point(200,80),80));
    }

    public String[] itemNames()
    {
        String names[] = new String[items.size()];
        for(int i=0;i<items.size();i++)
        {
            names[i]=items.get(i).getName();
        }
        return names;
    }

    public String[] getTypes()
    {
        String types[] = new String[NO_TYPES];
        types[0]="Rectangle";
        types[1]="Circle";
        types[2]="Triangle";
        types[3]="Segment";
        types[4]="Spiral";
        types[5]="Text";
        types[6]="Complex item";

        return types;
    }

    public String[] getBasicTypes()
    {
        String types[] = new String[NO_TYPES-1];
        types[0]="Rectangle";
        types[1]="Circle";
        types[2]="Triangle";
        types[3]="Segment";
        types[4]="Spiral";
        types[5]="Text";

        return types;
    }

    public boolean checkIfNameAlreadyExists(String name)
    {
        for(Item i:items)
        {
            if(i.getName().equals(name))
            {
                return false;
            }
        }
        return true;
    }



}
