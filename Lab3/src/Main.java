

public class Main {

    // "1/2 + 2/3"
    // "1/2 + 2/3 = 7/6"
    public String joesFunction(String str){
        // "1/2 + 2/3"
        String[] result = str.split(" ");
        // 0 "1/2"
        // 1 "+"
        // 2 "2/3"
        
        // "1/2"
        String[] part1 = result[0].split("///");
        // 0 "1"
        // 1 "2"
        int value = Integer.parseInt(part1[0]); // 1
        int valuetwo = Integer.parseInt(part1[1]);
        
        public int gcdThing(int value, int b) {
            BigInteger b1 = new BigInteger(""+a); // there's a better way to do this. I forget.
            BigInteger b2 = new BigInteger(""+b);
            BigInteger gcd = b1.gcd(b2);
            return gcd.intValue();
            }
        
        return b;
    }
}

