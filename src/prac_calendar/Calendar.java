package prac_calendar;
/**
 * 월을 입력하면 해당월의 달력을 출력한다.
 * 1일은 일요일로 정해도 무방하다.
 * -1을 입력받기 전까지 반복 입력받는다.
 * 프롬프트를 출력한다.
 */

public class Calendar {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
        final int STANDARD_WEEKDAY= 3; //(1st.Jan.1970: Thursday)

        int count = 0;

        for (int i = standardYear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }
        for (int j = 1; j < month; j++) {
            int delta = getMaxDays(year, j);
            count += delta;
        }

        count += day;
        int weekday = (count+STANDARD_WEEKDAY) % 7;
        return weekday;
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
