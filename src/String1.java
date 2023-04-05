import java.sql.Array;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class String1 {
    public static void main(String[] args) {
        String string = "aababcacdeeda";
        char[] result = new char[0];
        for (int i = 0; i < string.length(); i++) {
            if (i == 0) {
               result = new char[] addChar(result, i);
            }
        }
    }

    public static void addChar(char[] resultArr, int charIndex){

    }
}