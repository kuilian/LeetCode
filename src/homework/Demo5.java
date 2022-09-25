package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kui Lian
 * @date 2022/9/24 - 20:37
 * @Description:
 */
public class Demo5 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2,3,3,3, 3, 5};
        int f = f(arr, 0, arr.length-1);
        System.out.println("f = " + f);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int C = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(countElementPairs(nums, C));
    }
    

    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    //给定一个整数序列，返回众数
    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
//
        int mid = L + ((R - L) >> 1);
        int left = f(arr, L, mid);
        int right = f(arr, mid + 1, R);
        if (left == right) {
            return left;
        }
        //如果众数不相同，就要比较两边的次数大小
        int leftCount = countInRange(arr, left, L, R);
        int rightCount = countInRange(arr, right, L, R);
        return leftCount > rightCount ? left : right;

    }

    public static int  countElementPairs(int[] nums, int C) {
        int len = nums.length;
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            cnt += countTarget(nums, nums[i] + C);
        }
        return cnt;
    }

    // 统计有序数组中target的个数
    private static int countTarget(int[] nums, int target) {
        int borderL = serchLeftBorder(nums, target);
        int borderR = serchRightBorder(nums, target);
        if (borderL != -1 && borderR != -1) {
            return borderR - borderL + 1;
        } else {
            return 0;
        }
    }

    // 找有序数组中target的最左下标
    private static int serchLeftBorder(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 找有序数组中target的最右下标
    private static int serchRightBorder(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == len - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
