// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class String1 {
    public static void main(String[] args) {
        String string = "aababcacdeeda2314nnmtgh ku super to";
        for (int i = 0; i < string.length(); i++) {
            if (i == 0) {
                System.out.print(string.charAt(i) + ", ");
            } else {
                int loopCount = 0;
                for (int j = 0; j < i; j++) {
                    if (string.charAt(j)==string.charAt(i)) {
                        loopCount++;
                        break;
                    }
                }
                if (loopCount == 0 && string.charAt(i) != ' ') {
                    System.out.print(string.charAt(i) + ", ");
                }
            }
        }
      }
    }