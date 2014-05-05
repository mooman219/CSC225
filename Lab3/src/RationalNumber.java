
import java.math.BigInteger;

public class RationalNumber implements RationalExpressions {

    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public RationalNumber(String line) {
        String[] expression = line.split("///");
        numerator = Integer.parseInt(expression[0]);
        denominator = Integer.parseInt(expression[1]);
    }

    @Override
    public RationalNumber add(RationalNumber r) {
        int gcd = RationalNumber.gcd(this, r);
        numerator = (numerator * (gcd / denominator)) + (r.numerator * (gcd / r.denominator));
        denominator = gcd;
        return this;
    }

    @Override
    public RationalNumber sub(RationalNumber r) {
        int gcd = RationalNumber.gcd(this, r);
        numerator = (numerator * (gcd / denominator)) - (r.numerator * (gcd / r.denominator));
        denominator = gcd;
        return this;
    }

    @Override
    public RationalNumber mlt(RationalNumber r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RationalNumber div(RationalNumber r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean lt(RationalNumber r) {
        int gcd = RationalNumber.gcd(this, r);
        return (numerator * (gcd / denominator)) < (r.numerator * (gcd / r.denominator));
    }

    @Override
    public boolean gt(RationalNumber r) {
        int gcd = RationalNumber.gcd(this, r);
        return (numerator * (gcd / denominator)) > (r.numerator * (gcd / r.denominator));
    }

    @Override
    public boolean eq(RationalNumber r) {
        int gcd = RationalNumber.gcd(this, r);
        return (numerator * (gcd / denominator)) == (r.numerator * (gcd / r.denominator));
    }

    @Override
    public boolean le(RationalNumber r) {
        int gcd = RationalNumber.gcd(this, r);
        return (numerator * (gcd / denominator)) <= (r.numerator * (gcd / r.denominator));
    }

    @Override
    public boolean ge(RationalNumber r) {
        int gcd = RationalNumber.gcd(this, r);
        return (numerator * (gcd / denominator)) >= (r.numerator * (gcd / r.denominator));
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int geDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static int gcd(RationalNumber a, RationalNumber b) {
        return new BigInteger("" + a.denominator).gcd(new BigInteger("" + b.denominator)).intValue();
    }
}
