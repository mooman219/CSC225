
import java.math.BigInteger;

public class RationalNumber implements RationalExpressions {

    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public RationalNumber(String line) {
        String[] expression = line.split("/");
        numerator = Integer.parseInt(expression[0]);
        denominator = Integer.parseInt(expression[1]);
    }

    @Override
    public RationalNumber add(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        numerator = (numerator * (lcm / denominator)) + (r.numerator * (lcm / r.denominator));
        denominator = lcm;
        return this;
    }

    @Override
    public RationalNumber sub(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        numerator = (numerator * (lcm / denominator)) - (r.numerator * (lcm / r.denominator));
        denominator = lcm;
        return this;
    }

    @Override
    public RationalNumber mlt(RationalNumber r) {
        numerator *= r.numerator;
        denominator *= r.denominator;
        return this;
    }

    @Override
    public RationalNumber div(RationalNumber r) {
        numerator *= r.denominator;
        denominator *= r.numerator;
        return this;
    }

    @Override
    public boolean lt(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) < (r.numerator * (lcm / r.denominator));
    }

    @Override
    public boolean gt(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) > (r.numerator * (lcm / r.denominator));
    }

    @Override
    public boolean eq(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) == (r.numerator * (lcm / r.denominator));
    }

    @Override
    public boolean le(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) <= (r.numerator * (lcm / r.denominator));
    }

    @Override
    public boolean ge(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) >= (r.numerator * (lcm / r.denominator));
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

    public static int lcm(int a, int b) {
        return (a * b) / BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
