package match.weekly.weekly177.p1;

import java.time.LocalDate;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate a = LocalDate.parse(date1);
        LocalDate b = LocalDate.parse(date2);
        return (int) Math.abs(a.toEpochDay() - b.toEpochDay());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(new Solution().daysBetweenDates("2020-01-15", "2019-12-31"));
        System.out.println(new Solution().daysBetweenDates("1971-06-29", "2010-09-23"));
    }
}
