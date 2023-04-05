import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class String1 {
    public static void main(String[] args) {
        String string = "aababcacdeeda2314nnmtgh";
        char[] result = compareChar(string);
        for (char c: result
             ) {
            System.out.print(c + ", ");
        }
    }

    public static char[] compareChar(String string){
        char[] result = new char[0];
        for (int i = 0; i < string.length(); i++){
            if (i == 0){
              result = addChar(result,string.charAt(i));
            }
            if (i > 0) {
                int loopCount = 0;
                for (char c : result) {
                    if (c == string.charAt(i)) {
                        loopCount++;
                        break;
                    }
                }
                if (loopCount == 0){
                    result = addChar(result, string.charAt(i));
                }
            }
        }

        return  result;
    }

    public static char[] addChar(char[] resultArr, char newChar){
        char[] result = Arrays.copyOf(resultArr, resultArr.length + 1);
        result[result.length - 1] = newChar;
        return result;
    }
}