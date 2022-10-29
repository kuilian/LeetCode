package homework;

import java.util.Scanner;

public class Solution1 {

    private int maxMeetingTime(int[][] time) {
        traceBack(0, time, 1, new boolean[time.length]);
        return maxSum;
    }

    private int maxSum;

    private void traceBack(int tempSum, int[][] time, int available, boolean[] used) {
        maxSum = Math.max(maxSum, tempSum);
        for (int i = 0; i < time.length; i++) {
            if (!used[i] && time[i][0] >= available) {
                used[i] = true;
                traceBack(tempSum + time[i][1] - time[i][0], time, time[i][1], used);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] time = new int[len][2];
        for (int i = 0; i < len; i++) {
            time[i][0] = scanner.nextInt();
            time[i][1] = scanner.nextInt();
        }
        System.out.println(new Solution1().maxMeetingTime(time));
    }
}