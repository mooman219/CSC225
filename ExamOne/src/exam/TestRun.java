package exam;

public class TestRun {

    public static void main(String[] args) {
        ClassA x = new ClassA();
        int a = 10;
        int b = 12;
        System.out.println("Minimum " + x.minimum(a, b));
        System.out.println("Maximum " + x.maximum(a, b));
    }
}
