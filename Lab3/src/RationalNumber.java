
import java.math.BigInteger;

public class RationalNumber implements RationalExpressions {

    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    // takes in string from main and breaks it into num and denom
    public RationalNumber(String line) {
        String[] expression = line.split("/");
        numerator = Integer.parseInt(expression[0]);
        if(expression.length >= 2) {
            denominator = Integer.parseInt(expression[1]);
        } else {
            denominator = 1;
        }
    }
    //implementation of addition function from rational expressions
    @Override
    public RationalNumber add(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        numerator = (numerator * (lcm / denominator)) + (r.numerator * (lcm / r.denominator));
        denominator = lcm;
        return this;
    }
    //implementation of subtraction function from rational expressions
    @Override
    public RationalNumber sub(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        numerator = (numerator * (lcm / denominator)) - (r.numerator * (lcm / r.denominator));
        denominator = lcm;
        return this;
    }
    //implementation of multiplication function from rational expressions
    @Override
    public RationalNumber mlt(RationalNumber r) {
        numerator *= r.numerator;
        denominator *= r.denominator;
        return this;
    }
    //implementation of division function from rational expressions
    @Override
    public RationalNumber div(RationalNumber r) {
        numerator *= r.denominator;
        denominator *= r.numerator;
        return this;
    }
    //implementation of less than function from rational expressions
    @Override
    public boolean lt(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) < (r.numerator * (lcm / r.denominator));
    }
    //implementation of greater than function from rational expressions
    @Override
    public boolean gt(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) > (r.numerator * (lcm / r.denominator));
    }
    //implementation of equals function from rational expressions
    @Override
    public boolean eq(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) == (r.numerator * (lcm / r.denominator));
    }
    //implementation of less than equal to function from rational expressions
    @Override
    public boolean le(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) <= (r.numerator * (lcm / r.denominator));
    }
    //implementation of greater than equal to function from rational expressions
    @Override
    public boolean ge(RationalNumber r) {
        int lcm = RationalNumber.lcm(denominator, r.denominator);
        return (numerator * (lcm / denominator)) >= (r.numerator * (lcm / r.denominator));
    }
    //implementation of get numerator method from rational expressions, gets the numerator
    @Override
    public int getNumerator() {
        return numerator;
    }
    //implementation of get denominator method from rational expressions, gets the denominator
    @Override
    public int geDenominator() {
        return denominator;
    }
    // sets the numerator and denominator back to a fraction in a string
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    // lowest common multiple function
    public static int lcm(int a, int b) {
        return (a * b) / BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
