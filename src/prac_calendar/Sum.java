package prac_calendar;
import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        /*사용자로부터 두 수를 입력받고, 합을 출력한다.*/
        System.out.print("Input Two Numbers: ");
        Scanner s1 = new Scanner(System.in);
        int input1 = s1.nextInt();
        int input2 = s1.nextInt();
        int res = input1 + input2;
        System.out.printf("%d + %d = %d\n", input1, input2, res);


    }
}
