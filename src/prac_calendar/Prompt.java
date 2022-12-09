package prac_calendar;

import java.util.Scanner;

public class Prompt {
    private final static String PROMPT_YEAR = "YEAR > ";
    private final static String PROMPT_MONTH = "MONTH > ";
    private final static String PROMPT_WEEKDAY = "WEEKDAY > ";
    public static void main(String[] args) {
        //셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }

    /**
     * @param week: 요일명 (MON~SUN)
     * @return 0~6 (0 = Sunday, 6 = Saturday)
     */
    public int parseDay(String week){
        if(week.equals("SUN")) return 0;
        else if(week.equals("MON")) return 1;
        else if(week.equals("TUE")) return 2;
        else if(week.equals("WED")) return 3;
        else if(week.equals("THU")) return 4;
        else if(week.equals("FRI")) return 5;
        else if(week.equals("SAT")) return 6;
        else return 0;

    }
    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true) {
            System.out.println("Enter the year. (exit: -1)");
            System.out.print(PROMPT_YEAR);
            int year = scanner.nextInt();
            if(year == -1){
                System.out.println("EXIT");
                break; //loop에서 탈출함
            }

            System.out.println("Enter the month.");
            System.out.print(PROMPT_MONTH);
            int month = scanner.nextInt();
            if (month > 12 || month < 1) {
                System.out.println("Invaild Input");
                continue; //loop의 처음으로 돌아감
            }

            System.out.println("Enter the weekday. (Sun, Mon, Tue, Wed, Thu, Fri, Sat)");
            System.out.print(PROMPT_WEEKDAY);
            String str_weekday = scanner.next();
            int weekday = parseDay(str_weekday);

            cal.printCalendar(year, month, weekday);

        }
    }
}
