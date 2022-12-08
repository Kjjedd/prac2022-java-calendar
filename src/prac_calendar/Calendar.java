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
        System.out.println("22 23 24 25 26 27 28\n");

        /*입력받은 숫자에 해당하는 달의 최대 일수를 출력하는 프로그램*/

        //배열&함수이용
        String prompt = ("> ");
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        while (true) {
            System.out.println("Enter the Month");
            System.out.print(prompt);
            int m = scanner.nextInt();
            if(m == -1){
                System.out.println("Done");
                break; //loop에서 탈출함
            }
            if(m > 12){
                System.out.println("Enter the number less than 12");
                continue; //loop의 처음으로 돌아감
            }
            System.out.printf("The month(%d) has %ddays\n", m, cal.getMaxDays(m));

        }
        scanner.close();


          //조건문
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
