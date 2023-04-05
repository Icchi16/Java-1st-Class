import java.sql.Array;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class String1 {
    public static void main(String[] args) {
        String string = "aababcacdeeda";
        char[] result = new char[0];
        char[] arrtest = {'a','d','f'};
//        int[] newarr = Arrays.copyOf(arrtest,5);
//        for (int i: arrtest
//             ) {
//            System.out.println(i);
//        }
//        for (int i: newarr
//             ) {
//            System.out.println(i);
//        }


//        for (int i = 0; i < string.length(); i++) {
//            if (i == 0) {
//               result = new char[] addChar(result, i);
//            }
//        }
    }

    public static char[] addChar(char[] resultArr, char newChar){
        char[] result = Arrays.copyOf(resultArr, resultArr.length + 1);
        result[result.length - 1] = newChar;
        return result;
    }
}