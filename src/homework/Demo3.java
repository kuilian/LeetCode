package homework;

import java.util.*;
public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            int n = in.nextInt();
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (f(i) == g(i)) {
                    count++;
                }
            }
            System.out.println(count);

    }
    /** 二进制 */
    private static int g(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 2;
            n /= 2;
        }
        return sum;
    }
    /** 十进制 */
    private static int f(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}