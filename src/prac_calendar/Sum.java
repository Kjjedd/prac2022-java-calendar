package prac_calendar;
import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        /*사용자로부터 두 수를 입력받고, 합을 출력한다.*/

        //정수로 입력받기
        System.out.print("Input Two Numbers: ");
        Scanner s1 = new Scanner(System.in);
        int input1 = s1.nextInt();
        int input2 = s1.nextInt();
        int res = input1 + input2;
        System.out.printf("%d + %d = %d\n", input1, input2, res);

        //문자로 입력받아 정수로 변환하기
        System.out.print("Input Two Numbers: ");
        Scanner s2 = new Scanner(System.in);
        String input3 = s2.next();
        String input4 = s2.next();
        int a = Integer.parseInt(input3);
        int b = Integer.parseInt(input4);
        //Integer.parseInt() -> 정수형으로 변환
        System.out.printf("%d + %d = %d\n", a, b, a+b);
    }
}
