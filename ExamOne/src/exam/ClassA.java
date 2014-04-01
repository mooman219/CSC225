package exam;

public class ClassA extends BigClass {

    protected int d;
    private double e;
    public String s = " Java!";

    private int add() {
        return (int) (d + e);
    }

    @Override
    public String toString() {
        return super.c + s;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }
}
