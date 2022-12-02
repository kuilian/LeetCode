package exercise.class01;

import java.util.Arrays;

/**
 * @author Kui Lian
 * @date 2022/12/1 - 17:17
 * @Description:
 */
public class Code01_CordCoverMaxPoint {

//    public static int maxPoint1(int[] arr, int L) {
//        int res = 1;
//        for (int i = 0; i < arr.length; i++) {
//            //假设绳子的末尾来到每一个给定点  没有必要去不在指定点的位置
//            // 这个绳子能覆盖到最多的点： arr[i] - 绳子的长度 这个范围内 覆盖到的点数
//            //返回数组中在这个范围内最接近 大于等于最左边值的位置
//            int nestrest = nearestIndex(arr, i, arr[i] - L);
//            //为什么是i？
//            // 个数！就是当前数组的下标 减去nestest（是最大于等于范围内最左的值的下标） 最后加上自身 就是覆盖到的点
//            res = Math.max(res, i - nestrest + 1);
//        }
//        return res;
//    }

//    /***
//     * @Date 21:53 2022/12/1
//     * @Param [arr, R, value] R:结束点 value: 开头点最多只能退到的位置
//     * @return int
//     * @Description:  // 这个绳子能覆盖到最多的点： arr[i] - 绳子的长度 这个范围内 覆盖到的点数
//     *             //返回数组中在这个范围内最接近 大于等于最左边值的位置
//     */
//    public static int nearestIndex(int[] arr, int R, int value) {
//        //二分法
//        int index = R;
//        int L = 0;
//        while (L <= R) {
//            int mid = L + ((R - L) >> 1);
//            if (arr[mid] >= value) {
//                //为什么index = mid  如果当前位置值大于value 说明这个数在范围中 返回下标
//                index = mid;
//                R = mid - 1;
//            } else {
//                L = mid + 1;
//            }
//        }
//        return index;
//
//    }

    public static int maxPoint1(int[] arr, int L) {
        int res = 1;

        for (int i = 0; i < arr.length; i++) {

            int index = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - index + 1);
        }
        return res;


    }

    public static int nearestIndex(int[] arr, int R, int value) {
        int ans = R;
        int L = 0;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value)
            {
                ans = mid;
                R = mid-1;
            }else{
                L = mid + 1;
            }
        }
        return ans;
    }

    //滑动窗口
    public static int maxPoint2(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int ans = 0;
        while (left < N) {
            while (right < N && arr[right] - arr[left] <= L) {
                right++;
            }
            ans = Math.max(ans, right - (left++));

        }

        return ans;
    }

    // for test
    public static int test(int[] arr, int L) {
        //暴力 o（n^2)的解
        // 往左边推 能盖住几个点 绳子末尾处不必要压在一个不存在的位置
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            //arr[i] - arr[L] >= L : 绳子末尾处不必要压在一个不存在的位置
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            // i - pre （pre只有到-1的时候才会到此处 即结果会自动加一）
            max = Math.max(max, i - pre);
        }
        return max;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 5;
        int max = 10;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
//            int L = (int) (Math.random() * max);
            int L = 6;
            int[] arr = generateArray(len, max);


            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println("oops!");
                break;
            }
        }
//        test(new int[]{1, 3, 4, 7, 13}, 4);
    }

}

