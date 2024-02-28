public class 输出等腰三角形 {
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("1 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(5);
    }

    public static void print2(int n) {
         for (int i = 1; i <= n; i++) {
            // 打印空格
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // 打印星号
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // 换行
            System.out.println();
        }
    }
}
