package normal.cat2.cat21.p2166;

class Bitset {

    private final boolean[] bits;
    private int size = 0;
    private int fixSize = 0;
    private boolean bitsFlip = false;

    public Bitset(int size) {
        this.size = size;
        this.bits = new boolean[size + 1];
    }

    public void fix(int idx) {
        if (this.bits[idx] == bitsFlip) {
            this.fixSize += 1;
        }
        this.bits[idx] = !bitsFlip;
    }

    public void unfix(int idx) {
        if (this.bits[idx] == !bitsFlip) {
            this.fixSize -= 1;
        }
        this.bits[idx] = bitsFlip;
    }

    public void flip() {
        this.bitsFlip = !this.bitsFlip;
        this.fixSize = this.size - this.fixSize;
    }

    public boolean all() {
        return fixSize == size;
    }

    public boolean one() {
        return fixSize > 0;
    }

    public int count() {
        return fixSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (bitsFlip) {
                sb.append(bits[i] ? '0' : '1');
            } else {
                sb.append(bits[i] ? '1' : '0');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Bitset bs = new Bitset(5); // bitset = "00000".
        bs.fix(3);     // 将 idx = 3 处的值更新为 1 ，此时 bitset = "00010" 。
        bs.fix(1);     // 将 idx = 1 处的值更新为 1 ，此时 bitset = "01010" 。
        bs.flip();     // 翻转每一位上的值，此时 bitset = "10101" 。
        System.out.println(bs.all());      // 返回 False ，bitset 中的值不全为 1 。
        bs.unfix(0);   // 将 idx = 0 处的值更新为 0 ，此时 bitset = "00101" 。
        bs.flip();     // 翻转每一位上的值，此时 bitset = "11010" 。
        System.out.println(bs.one());      // 返回 True ，至少存在一位的值为 1 。
        bs.unfix(0);   // 将 idx = 0 处的值更新为 0 ，此时 bitset = "01010" 。
        System.out.println(bs.count());    // 返回 2 ，当前有 2 位的值为 1 。
        System.out.println(bs.toString()); // 返回 "01010" ，即 bitset 的当前组成情况。
    }
}
