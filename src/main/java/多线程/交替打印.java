package 多线程;

import javax.swing.plaf.TreeUI;

/**
 * 三个线程交替打印abc，打印100个字符
 */
public class 交替打印 {
    private static Integer state = 0;
    private static final Object lock = new Object();
    private static Integer count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count + 1 <= 100 && state == 0) {
                        System.out.println("A");
                        lock.notifyAll();
                        count++;
                        state = 1;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count + 1 <= 100 && state == 1) {
                        System.out.println("B");
                        lock.notifyAll();
                        count++;
                        state = 2;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count + 1 <= 100 && state == 2) {
                        System.out.println("C");
                        lock.notifyAll();
                        count++;
                        state = 0;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }).start();
    }



}
