package 多线程;

public class 死锁 {
    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (B) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (A) {
                    System.out.println("2");
                }
            }
        }).start();

    }
}
