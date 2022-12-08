package prac_calendar;

/**
 * 월을 입력하면 해당월의 달력을 출력한다.
 * 1일은 일요일로 정해도 무방하다.
 * -1을 입력받기 전까지 반복 입력받는다.
 * 프롬프트를 출력한다.
 */

public class Calendar {
    private static final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    //입력받은 달의 최대 일 수를 출력하는 함수
    public int getMaxDays(int m) {
        return maxDays[m-1];
    }

    public void printCalendar(int year, int m) {
        System.out.printf("           <<%d, %d>>\n", m, year);
        System.out.println("  SUN  MON  TUE  WED  THU  FRI  SAT");
        System.out.println("  ---------------------------------");
        int maxDays = getMaxDays(m);
        for (int i = 1; i <= maxDays; i++) {
            System.out.printf("%5d", i);
            if(i%7==0)
            System.out.println();
        }

        System.out.println("\n  ---------------------------------");
    }




}
