import jdk.nashorn.internal.ir.CaseNode;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lựa chọn phép tính");
        System.out.println("1. Cộng");
        System.out.println("2. Trừ");
        System.out.println("3. Nhân");
        System.out.println("4. Chia");
        int calNum = scanner.nextInt();
        String calMethod = "";
        switch (calNum) {
            case 1:
                calMethod = "Cộng";
                break;
            case 2:
                calMethod = "Trừ";
                break;
            case 3:
                calMethod = "Nhân";
                break;
            case 4:
                calMethod = "Chia";
                break;
        }
        System.out.println("Bạn đang chọn phép tính " + calMethod);
        System.out.println("Hãy nhập số đầu tiên");
        int num1 = scanner.nextInt();
        System.out.println("Hãy nhập số thứ hai");
        int num2 = scanner.nextInt();
        int result = Calculation(calNum,num1,num2);
        System.out.println("Kết quả phép tính: " + result);
    }

    public static int Calculation (int calNum, int num1, int num2){
        int result = 0;

        switch (calNum){
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;
        }
        return result;
    }
}

