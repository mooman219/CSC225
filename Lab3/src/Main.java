
public class Main {

    public static void main(String args[]) {
        new Calculator().setVisible(true);
    }

    public static String calculate(String str) {
        RationalNumber a, b;
        String[] breakdown = str.split(" ");
        StringBuilder ret = new StringBuilder(str);
        ret.append(" = ");

        try {
            a = new RationalNumber(breakdown[0]);
            b = new RationalNumber(breakdown[2]);
        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return "Invalid number format.";
        }

        switch(breakdown[1]) {
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
                return "Invalid operator";
        }

        return ret.toString();
    }
}
