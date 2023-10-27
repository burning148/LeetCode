package 单例;

public class Singleton {
    private static volatile Singleton instance; // volatile保证多线程环境下的可见性
    // 私有构造方法
    private Singleton() {

    }
    private static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
