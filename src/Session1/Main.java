package Session1;

import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String string = "aababcacdeeda2314nnmtgh";
        kuto(string);
    }

    public static void kuto(String string) {
        int count;
        boolean isExist = false;
        for (int i = 0; i < string.length(); i++) {
            count = kuto2(string, string.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if(string.charAt(i) == string.charAt(j)) {
                    isExist = true;
                    break;
                } else {
                    isExist = false;
                }
            }
            if (!isExist) {
                System.out.println(string.charAt(i) + "---------" + count);
            }
        }
    }

    public static int kuto2(String string, char c) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (c == string.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}