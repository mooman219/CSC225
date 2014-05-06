
import java.math.BigInteger;

public class Main{

    // "1/2 + 2/3 = 7/6"
    public static String doStuff(String str) {
        String[] result = str.split(" ");
        RationalNumber rationalValue = new RationalNumber(1,1);
        boolean boolValue;
        
        
        RationalNumber a = new RationalNumber(result[0]);
        RationalNumber b = new RationalNumber(result[2]);
        switch(result[1]) {
            case "+":
                rationalValue = a.add(b);
                break;
            case "-":
               rationalValue = a.sub(b);
                break;
            case "*":
                rationalValue = a.mlt(b);
                break;
            case "/":
                rationalValue = a.div(b);
                break;
            case "<":
                boolValue = a.lt(b);
                break;
            case ">":
                boolValue = a.gt(b);
                break;
            case "=":
                boolValue = a.eq(b);
                break;
            case "<=":
                boolValue = a.le(b);
                break;
            case ">=":
                boolValue = a.ge(b);
                break;
        }
        
        return rationalValue.toString();
    }
}
