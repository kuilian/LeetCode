//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 320 👎 0

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> listNodes = new Stack<ListNode>();
        ListNode index = head;
        while (index !=null){
            listNodes.push(index);
            index = index.next;
        }
        int[] arr = new int[listNodes.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = listNodes.pop().val;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}