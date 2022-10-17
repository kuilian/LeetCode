package homework;

/**
 * @author Kui Lian
 * @date 2022/10/17 - 19:09
 * @Description:
 */
public class Demo7 {
    public static void main(String[] args) {
        int i = waysToChange(10);
        System.out.println("i = " + i);

    }


    public static int waysToChange(int n) {
        int[] coins = new int[]{1,2,5};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) ;

                }
            }
        }
        return dp[n];
    }


}
