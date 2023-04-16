package Session2.demo;

public class Rectangle {
    private int longer;
    private int shorter;


    public Rectangle(int longer, int shorter) {
        this.longer = longer;
        this.shorter = shorter;
    }

    public Rectangle() {

    }

    public int getLonger() {
        return longer;
    }

    public void setLonger(int longer) {
        this.longer = longer;
    }

    public int getShorter() {
        return shorter;
    }

    public void setShorter(int shorter) {
        this.shorter = shorter;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "longer=" + longer +
                ", shorter=" + shorter +
                '}';
    }

    public void getArea() {
        System.out.println("Area= " + longer * shorter);
    }
}
