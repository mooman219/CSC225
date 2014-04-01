package exam;

import java.util.Objects;

public abstract class BigClass implements BigInt {
    protected int a = 10;
    private double b;
    public String c = "I love";

    public BigClass(double b) {
        this.b = b;

    }

    public BigClass() {
        this.b = 0;
    }

    @Override
    public String toString() {
        return c;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj instanceof BigClass) {
            return false;
        }
        final BigClass other = (BigClass) obj;
        if(this.a != other.a) {
            return false;
        }
        if(this.b != other.b) {
            return false;
        }
        if(!Objects.equals(this.c, other.c)) {
            return false;
        }
        return true;
    }

    @Override
    public long maximum(int a, int b) {
        return a > b ? a : b;
    }

    @Override
    public int minimum(int a, int b) {
        return a < b ? a : b;
    }

    public abstract int mult(int a, int b);
}
