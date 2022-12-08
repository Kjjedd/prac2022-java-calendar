package prac_calendar;

import java.util.Scanner;

public class Prompt {
    private final static String PROMPT_YEAR = "YEAR > ";
    private final static String PROMPT_MONTH = "MONTH > ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        while (true) {
            System.out.println("Enter the year");
            System.out.print(PROMPT_YEAR);
            int year = scanner.nextInt();
            System.out.println("Enter the month");
            System.out.print(PROMPT_MONTH);
            int month = scanner.nextInt();
            if (month == -1 || year == -1) {
                System.out.println("Done");
                break; //loop에서 탈출함
            }
            if (month > 12) {
                System.out.println("Enter the month less than 12");
                continue; //loop의 처음으로 돌아감
            }
            cal.printCalendar(year, month);

        }
    }
    public static void main(String[] args) {
        //셀 실행
        Prompt p = new Prompt();
        p.runPrompt();

    }

}
