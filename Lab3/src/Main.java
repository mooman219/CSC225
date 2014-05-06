
public class Main {

    public static String doStuff(String str) {
        String[] result = str.split(" ");
        StringBuilder ret = new StringBuilder(str);
        ret.append(" = ");

        RationalNumber a = new RationalNumber(result[0]);
        RationalNumber b = new RationalNumber(result[2]);
        switch(result[1]) {
            case "+":
                ret.append(a.add(b).toString());
                break;
            case "-":
                ret.append(a.sub(b).toString());
                break;
            case "*":
                ret.append(a.mlt(b).toString());
                break;
            case "/":
                ret.append(a.div(b).toString());
                break;
            case "<":
                ret.append(a.lt(b));
                break;
            case ">":
                ret.append(a.gt(b));
                break;
            case "=":
            case "==":
                ret.append(a.eq(b));
                break;
            case "<=":
                ret.append(a.le(b));
                break;
            case ">=":
                ret.append(a.ge(b));
                break;
            default:
                return "Error";
        }

        return ret.toString();
    }
}
