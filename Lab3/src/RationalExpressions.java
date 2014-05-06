
interface RationalExpressions {
    //addition function
    public RationalNumber add(RationalNumber r);
    //subtraction function
    public RationalNumber sub(RationalNumber r);
    //multiplication function
    public RationalNumber mlt(RationalNumber r);
    // division function
    public RationalNumber div(RationalNumber r);
    // less than function
    public boolean lt(RationalNumber r);
    //greater than function
    public boolean gt(RationalNumber r);
    //equals function
    public boolean eq(RationalNumber r);
    //less than equal to function
    public boolean le(RationalNumber r);
    //greater than equal to function
    public boolean ge(RationalNumber r);
    // get numerator method
    public int getNumerator();
    // get denominator function
    public int geDenominator();
}
