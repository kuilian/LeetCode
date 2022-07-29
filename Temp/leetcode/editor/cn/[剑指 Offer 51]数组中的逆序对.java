//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 
// 👍 807 👎 0

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            return process(nums, 0, nums.length - 1);
        }

        public int process(int[] arr, int L, int R) {
            if (L == R)
                return 0;
            int mid = L + ((R - L) >> 1);
            return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);

        }

        public int merge(int[] arr, int l, int m, int r) {
            int[] help = new int[r - l + 1];
            int p1 = m;
            int p2 = r;
            int res = 0;
            int i = help.length - 1;

            while (p1 >= l && p2 > m) {
                res += arr[p1] > arr[p2] ? p2 - m : 0;
                help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
            }
            while (p1>=l)
            {
                help[i--] = arr[p1--];
            }
            while (p2>m)
            {
                help[i--] = arr[p2--];
            }
            for (int j = 0; j < help.length; j++) {
                arr[j + l] = help[j];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}