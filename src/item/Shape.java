package item;

import java.awt.*;

public abstract class Shape extends Primitive{

    private boolean filled;

    public Shape(String name, Color color, boolean isFilled) {
        super(name,color);
        filled=isFilled;
    }


    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

}
