package match.weekly.weekly189.p1;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i = 0; i < startTime.length; ++i) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                cnt += 1;
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
