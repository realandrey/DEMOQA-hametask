package guru.qa;

public class TestOperators {

    public static void main(String... args) {
        performIntAddition();
        performDoubleMultiplication();
        performSubtraction();
    }

    private static void performIntAddition() {
        int a = 2147483647;
        int b = 1000000000;
        System.out.println("Сумма int: " + (a + b));
    }

    private static void performDoubleMultiplication() {
        double a = Double.MAX_VALUE;
        int b = 1000000000;
        System.out.println("Произведение double и int: " + (a * b));
    }

    private static void performSubtraction() {
        int a = 23;
        double b = 10.4444444;
        System.out.println("Разница int и double: " + (a - b));
    }
}