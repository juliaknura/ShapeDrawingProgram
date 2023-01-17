package item;

public class Point {
    private int x;
    private int y;

    public Point() {
        x=0;
        y=0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int a, int b)
    {
        x+=a;
        y+=b;
    }


}
