package match.biweekly.biweekly30.p1;

import java.util.Arrays;
import java.util.List;

class Solution {

    private static final List<String> M = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

    public String reformatDate(String date) {
        String[] split = date.split("\\s");
        String year = split[2];
        String month = String.format("%02d", M.indexOf(split[1]) + 1);
        String day =  split[0].substring(0, Character.isDigit(split[0].charAt(1)) ? 2 : 1);
        day = String.format("%02d", Integer.parseInt(day));
        return year + "-" + month + "-" + day;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reformatDate("20th Oct 2052"));
        System.out.println(new Solution().reformatDate("6th Jun 1933"));
        System.out.println(new Solution().reformatDate("26th May 1960"));
    }
}
