
import java.math.BigInteger;

public class Main {

    // "1/2 + 2/3 = 7/6"
    public String doStuff(String str) {
        String[] result = str.split(" ");
        RationalNumber a = new RationalNumber(result[0]);
        RationalNumber b = new RationalNumber(result[2]);
        switch(result[1]) {
            case "+":
                break;
            case "-":
                break;
            case "*":
                break;
            case "/":
                break;
            case "<":
                break;
            case ">":
                break;
            case "=":
                break;
            case "<=":
                break;
            case ">=":
                break;
        }
    }
}
