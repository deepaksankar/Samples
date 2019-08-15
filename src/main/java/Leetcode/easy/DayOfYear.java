package main.java.Leetcode.easy;

public class DayOfYear {
    public static void main(String[] args) {

    }
    static int dayOfYear(String date) {
        int[] numOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(date == null || date.length() == 0) {
            return 0;
        }
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int days = Integer.parseInt(date.substring(8));
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {
                    numOfDays[1] = 29;
                }
            } else {
                numOfDays[1] = 29;
            }
        }
        int dayOfYear = 0;
        for(int mon = 0; mon < month-1; mon++) {
            dayOfYear += numOfDays[mon];
        }
        dayOfYear += days;

        return dayOfYear;
    }
}
