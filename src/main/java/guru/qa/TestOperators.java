package guru.qa;

public class TestOperators {

    public static void main(String... args) {
        // Пример 1: работа с int
        int a = 21474;
        int b = 100;
        int result1 = a+b;
        int result2 = a-b;

        System.out.println(a+b);
        System.out.println(a*b);
        System.out.println(b-a);
        System.out.println(a/b);
        System.out.println(a%b);
        System.out.println(++a);
        System.out.println(--b);

        // Пример 2: работа с double и int
        double c = Double.MAX_VALUE;
        int d = 1000000000;
        System.out.println("Произведение double и int: " + (c * d));

        // Пример 3: работа с int и double
        int e = 23;
        double f = 10.4444444;
        System.out.println("Разница int и double: " + (e - f));

        //Пример 4: Логические операторы
        boolean g = true;
        boolean k = false;
        System.out.println(result1 == 1 && result2 ==21374);
        System.out.println(result1 == 21574 || result2 == 21374);
        System.out.println(!(result1 == 21374 ));
    }
}
