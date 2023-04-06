// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Prime {
    public static void main(String[] args) {
        int max = 20;
        for (byte i = 1; i <= max; i++) {
            boolean isPrime = true;
            for (byte j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + ", ");
            }
        }
    }
}
