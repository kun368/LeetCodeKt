package normal.cat1.cat11.cat111.p1115.v2;

import java.util.concurrent.Semaphore;

class FooBar {

    private int n;
    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
        try {
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s1.acquire();
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            printBar.run();
            s1.release();
        }
    }
}