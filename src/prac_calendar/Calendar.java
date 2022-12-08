package prac_calendar;

import java.util.Scanner;

public class Calendar {
    private static final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDays(int m) {
        return maxDays[m-1];
    }
    //입력받은 달의 최대 일 수를 출력하는 함수

    public static void main(String[] args) {
        System.out.println("S  M  T  W  T  F  S");
        System.out.println("----------------------");
        System.out.println("1  2  3  4  5  6  7");
        System.out.println("8  9  10 11 12 13 14");
        System.out.println("15 16 17 18 19 20 21");
        System.out.println("22 23 24 25 26 27 28");

        /*입력받은 숫자에 해당하는 달의 최대 일수를 출력하는 프로그램*/

        //배열&함수이용
        System.out.print("Enter the number to repeat: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n ; i++) {
            System.out.print("Enter the Month: ");
            int m = scanner.nextInt();
            Calendar cal = new Calendar();
            System.out.printf("The month(%d) has %ddays\n", m, cal.getMaxDays(m) );
        }
        System.out.println("Done");
        scanner.close();
//        //조건문
//        if((m ==1) || (m == 3) ||  (m == 5) ||  (m == 7) ||  (m == 8) ||  (m == 10) || (m == 12)){
//            System.out.println("The month has 31days");
//        }
//        else if(m==2){
//            System.out.println("The month has 28days");
//        }
//        else{
//            System.out.println("The month has 30days");
//        }
//        System.out.println("--------------------");

    }
}
