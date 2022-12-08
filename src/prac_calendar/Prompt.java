package prac_calendar;

import java.util.Scanner;

public class Prompt {
    private final static String PROMPT = "MONTH> ";
    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        while (true) {
            System.out.print(PROMPT);
            int m = scanner.nextInt();
            if (m == -1) {
                System.out.println("Done");
                break; //loop에서 탈출함
            }
            if (m > 12) {
                System.out.println("Enter the month less than 12");
                continue; //loop의 처음으로 돌아감
            }
            cal.printCalendar(2022, m);

        }
    }
    public static void main(String[] args) {
        //셀 실행
        Prompt p = new Prompt();
        p.runPrompt();

    }

}
