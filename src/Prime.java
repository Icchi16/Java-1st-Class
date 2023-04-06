// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Prime {
    public static void main(String[] args) {
        int maxPrimeCount = 20;
        int primeCount = 0;
        int num = 2;
        while (primeCount < maxPrimeCount) {
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeCount++;
                System.out.print(num + ", ");
            }
            num++;
        }
    }
}
