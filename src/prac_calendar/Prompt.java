package prac_calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

    private final static String PROMPT_CMD = "> ";
    private final static String PROMPT_YEAR = "YEAR > ";
    private final static String PROMPT_MONTH = "MONTH > ";
    public void runPrompt() throws ParseException {
        cmdMenu();

        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        boolean isLoop = true;

        while (isLoop) {
            System.out.println("Enter (1, 2, 3, h, q)");
            System.out.print(PROMPT_CMD);
            String cmd = scanner.next();
            switch (cmd){
                case "1":
                    cmdRegister(scanner, cal);
                    break;
                case "2":
                    cmdSearch(scanner, cal);
                    break;
                case "3":
                    cmdCalendar(scanner, cal);
                    break;
                case "h":
                    cmdMenu();
                    break;
                case "q":
                    System.out.println("Done");
                    isLoop = false;
                    break;
            }
        }
        scanner.close();
    }
    public void cmdMenu(){
        System.out.println("+---------------------------+");
        System.out.println("| 1. Schedule Registration");
        System.out.println("| 2. Schedule Search");
        System.out.println("| 3. Calendar");
        System.out.println("| h. help q. Quit");
        System.out.println("+---------------------------+");
    }
    private void cmdCalendar(Scanner scanner, Calendar cal) {
        System.out.println("Enter the year.");
        System.out.print(PROMPT_YEAR);
        int year = scanner.nextInt();

        System.out.println("Enter the month.");
        System.out.print(PROMPT_MONTH);
        int month = scanner.nextInt();

        if (month > 12 || month < 1) {
            System.out.println("Invalid Input");
            return;
        }
        cal.printCalendar(year, month);
    }

    private void cmdSearch(Scanner scanner, Calendar cal){
        System.out.println("[Schedule Search]");
        System.out.println("Enter the date. [yyyy-MM-dd]");
        System.out.print(PROMPT_CMD);
        String date = scanner.next();
        PlanItem plan = cal.searchPlan(date);
        if(plan != null){
            System.out.println(plan.detail);
        }else{
            System.out.println("No Schedule");
        }
    }
    public void cmdRegister(Scanner scanner, Calendar cal){
        System.out.println("[Register a new event]");
        System.out.println("Enter the date. [yyyy-MM-dd]");
        System.out.print(PROMPT_CMD);
        String date = scanner.next();
        String text = "";
        scanner.nextLine();
        System.out.println("Enter the new event.");
        System.out.print(PROMPT_CMD);
        text = scanner.nextLine();
        cal.registerPlan(date, text);
    }
    public static void main(String[] args) throws ParseException {
        //셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
