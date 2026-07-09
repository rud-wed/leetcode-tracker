// Last updated: 7/9/2026, 10:24:01 AM
class Solution {
    public int dayOfYear(String date) {
        // Extract year, month, day from the string
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        // Days in each month (default for non-leap year)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Adjust February for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Add days from previous months + current day
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }

        return dayOfYear;
    }

    private boolean isLeapYear(int year) {
        // Leap year rule: divisible by 400 OR divisible by 4 but not by 100
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
