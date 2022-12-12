package prac_calendar;

import java.util.Scanner;

public class Prompt {
    private final static String PROMPT_YEAR = "YEAR > ";
    private final static String PROMPT_MONTH = "MONTH > ";

//    public int getWeekday(String week){
//        switch (week){
//            case "SUN": return 0;
//            case "MON": return 1;
//            case "TUE": return 2;
//            case "WED": return 3;
//            case "THU": return 4;
//            case "FRI": return 5;
//            case "SAT": return 6;
//            default: return 0;
//        }
//    }
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
                System.out.println("Invalid Input");
                continue; //loop의 처음으로 돌아감
            }

            cal.printCalendar(year, month);
        }
        scanner.close();
    }
    public static void main(String[] args) {
        //셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
