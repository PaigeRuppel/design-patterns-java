public class LiskovExample {
}


class Rectangle {
    protected int width;
    protected int height;

    public Rectangle() {

    }

    public Rectangle(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() { return width *height; }

    @Override
    public String toString() {
        return  "Rectangle{width=" + width + ", height=" + height + "}";
    }
}

class Square extends Rectangle {
    public Square() {}
    public Square(int side) {
        width = height = side;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}