package cat0.cat03.cat030.p307.v1;

/**
 * 树状数组版
 */
class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int change = val - (sum(i) - sum(i - 1));
        for (int t = i + 1; t < nums.length; t += t & (-t)) {
            nums[t] += change;
        }
    }

    private int sum(int i) {
        int ret = 0;
        for (int t = i + 1; t > 0; t -= t & (-t)) {
            ret += nums[t];
        }
        return ret;
    }
    
    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5};
        NumArray arr = new NumArray(ints);
        System.out.println(arr.sumRange(0, 2));
        arr.update(1, 2);
        System.out.println(arr.sumRange(0, 2));
    }
}