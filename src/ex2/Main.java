package ex2;

public class Main {
    public static void main(String[] args) {
        int number = 10;

        if (isEven(number)) {
            System.out.println(number + " — четное число.");
        } else {
            System.out.println(number + " — нечетное число.");
        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0 ? true : false;
    }
}