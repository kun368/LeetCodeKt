package normal.cat2.cat21.p2119;

class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        return !String.valueOf(num).endsWith("0");
    }
}
