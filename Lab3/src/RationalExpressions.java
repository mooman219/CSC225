
interface RationalExpressions {

    public RationalNumber add(RationalNumber r);

    public RationalNumber sub(RationalNumber r);

    public RationalNumber mlt(RationalNumber r);

    public RationalNumber div(RationalNumber r);

    public boolean lt(RationalNumber r);

    public boolean gt(RationalNumber r);

    public boolean eq(RationalNumber r);

    public boolean le(RationalNumber r);

    public boolean ge(RationalNumber r);

    public int getNumerator();

    public int geDenominator();

    public static class RationalNumber {

    }
}
