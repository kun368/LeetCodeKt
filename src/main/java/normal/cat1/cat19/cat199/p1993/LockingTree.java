package normal.cat1.cat19.cat199.p1993;

import java.util.ArrayList;

class LockingTree {

    private final int[] parent;
    private final int[] lockUser;
    private final ArrayList<ArrayList<Integer>> son;

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;
        this.lockUser = new int[n];
        this.son = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            son.add(new ArrayList<>());
            lockUser[i] = -1;
        }
        for (int i = 1; i < parent.length; ++i) {
            son.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (this.lockUser[num] != -1) {
            return false;
        }
        this.lockUser[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if (this.lockUser[num] != user) {
            return false;
        }
        this.lockUser[num] = -1;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if (this.lockUser[num] != -1) {
            return false;
        }

        int par = this.parent[num];
        boolean ok = true;
        while (par != -1) {
            if (this.lockUser[par] != -1) {
                ok = false;
                break;
            }
            par = this.parent[par];
        }
        if (!ok) return false;

        int unlockSonSize = unlockSon(num);
        if (unlockSonSize == 0) {
            return false;
        }

        this.lockUser[num] = user;
        return true;
    }

    private int unlockSon(int num) {
        int ret = 0;
        for (Integer s : this.son.get(num)) {
            ret += unlockSon(s);
        }
        if (this.lockUser[num] != -1) {
            this.lockUser[num] = -1;
            ret += 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(lockingTree.lock(2, 2));
        System.out.println(lockingTree.unlock(2, 3));
        System.out.println(lockingTree.unlock(2, 2));
        System.out.println(lockingTree.lock(4, 5));
        System.out.println(lockingTree.upgrade(0, 1));
        System.out.println(lockingTree.lock(0, 1));
    }
}
