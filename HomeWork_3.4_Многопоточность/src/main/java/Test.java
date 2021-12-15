public class Test {

    volatile int status = 0;

    public static void main(String[] args) {
        Test lock = new Test();
        Thread one = new Thread(new Task("A", lock, 1));
        Thread two = new Thread(new Task("B", lock, 2));
        Thread three = new Thread(new Task("C", lock, 3));
        one.start();
        two.start();
        three.start();
    }

    static class Task implements Runnable {
        private String message;
        private final Test lock;
        private int p;

        Task(String text, Test obj, int p) {
            message = text;
            this.lock = obj;
            this.p = p;
        }

        @Override
        public void run() {
            while (lock.status < 13) {
                synchronized (lock) {
                    while (!((lock.status % 3) == 0) && p == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    while (!((lock.status % 3) == 1) && p == 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    while (!((lock.status % 3) == 2) && p == 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.print(message);
                    lock.status++;
                    if ((lock.status % 3) == 0) System.out.print("|");
                    lock.notifyAll();
                }
            }
        }
    }
}
