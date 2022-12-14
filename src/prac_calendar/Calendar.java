package prac_calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String SAVE_FILE = "calendar.dat";

    public boolean isLeapYear(int year){
        if(year%4 ==0 && (year%100 != 0) || (year%400 == 0)){
            return true;
        }
        else
            return false;
    }
    public int getMaxDays(int year, int month) {
        if(isLeapYear(year)){
            return LEAP_MAX_DAYS[month];
        }
        else
            return MAX_DAYS[month];
    }

    private int getWeekday(int year, int month, int day) {
        int standardYear = 1970;
        final int STANDARD_WEEKDAY= 4; //(1st.Jan.1970: Thursday)

        int count = 0;

        for (int i = standardYear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }
        for (int j = 1; j < month; j++) {
            int delta = getMaxDays(year, j);
            count += delta;
        }

        count += day - 1 ;
        int weekday = (count+STANDARD_WEEKDAY) % 7;
        return weekday;
    }

    private HashMap<Date, PlanItem> planMap;

    public Calendar(){
       planMap = new HashMap<Date, PlanItem>();
       File f = new File(SAVE_FILE);
       if (!f.exists()){
           System.err.println("[NO SAVE SCHEDULE]");
           return;
       }
        try {
            System.err.println("HAVE SCHEDULES");
            Scanner s = new Scanner(f);
            while(s.hasNext()){
                String line = s.nextLine();
                String[] words = line.split(",");
                String date = words[0];
                String detail = words[1].replaceAll("\"", "");
                PlanItem p = new PlanItem(date, detail);
                planMap.put(p.getPlanDate(), p);
            }
            s.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param strDate: ex) "2022-10-07
     * @param plan: ex) "Today is Birthday"
     */

    public void registerPlan(String strDate, String plan){
        PlanItem p = new PlanItem(strDate, plan);
        planMap.put(p.getPlanDate(), p);

        File f = new File(SAVE_FILE);
        String item = p.saveString();
        try {
            FileWriter fw = new FileWriter(f, true);
            fw.write(item);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public PlanItem searchPlan(String strDate) {
        Date date = PlanItem.getDateFromString(strDate);
        return planMap.get(date);
    }

    public void printCalendar(int year, int month) {
        System.out.printf("           <<%d년 %d월>>\n", year, month);
        System.out.println("  SUN  MON  TUE  WED  THU  FRI  SAT");
        System.out.println("  ---------------------------------");

        //get weekday automatically
        int weekday = getWeekday(year, month, 1);

        //print blank space
        for (int i = 0; i < weekday; i++) {
            System.out.print("     ");
        }

        int maxDays = getMaxDays(year, month);

        //print first line
        int count = 7 - weekday;
        int delim = (count < 7) ? count : 0;

        for (int i = 1; i <= count; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();

        //print from second to last line
        count++;
        for (int i = count; i <= maxDays; i++) {
            System.out.printf("%5d", i);
            if (i % 7 == delim) {
                System.out.println();
            }
        }

        System.out.println("\n  ---------------------------------");
    }
}
