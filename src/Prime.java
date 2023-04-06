// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Prime {
    public static void main(String[] args) {
        int max = 20;
        for (byte i = 1; i <= max; i++) {
            int primeCount = 0;
            for (byte j = 1; j <= i; j++) {
                if (i % j == 0) {
                    primeCount++;
                }
            }
            if (primeCount == 2 || (primeCount == 1 && i == 1)) {
                System.out.print(i + ", ");
            }
        }
    }
}
