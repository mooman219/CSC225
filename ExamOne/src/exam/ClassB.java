package exam;

public class ClassB extends BigClass {

    private int f;
    protected static char g = 'A';

    public char getG() {
        return g;
    }

    public ClassB(int f, double b) {
        super(b);
        this.f = f;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }
}
