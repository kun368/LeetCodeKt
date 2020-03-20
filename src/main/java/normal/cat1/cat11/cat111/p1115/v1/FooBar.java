package normal.cat1.cat11.cat111.p1115.v1;

class FooBar {

    private int n;
    private volatile int curr = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (curr == 0) {
                    printFoo.run();
                    break;
                }
            }
            curr = 1;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (true) {
                if (curr == 1) {
                    printBar.run();
                    break;
                }
            }
            curr = 0;
        }
    }
}