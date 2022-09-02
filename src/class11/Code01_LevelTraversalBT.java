package class11;

import java.util.LinkedList;
import java.util.Queue;

public class Code01_LevelTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        level(head);
        System.out.println("========");
    }

    /***
     * @Date 22:20 2022/9/2
     * @Param [head]
     * @return void
     * @Description: 层次遍历二叉树（宽度遍历）
     */
    private static void level(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> node = new LinkedList<>();
        node.add(head);
        while (!node.isEmpty()) {   //弹出结点并打印
            Node cur = node.poll();
            System.out.println(cur.value + " ");
            //看当前结点有没有左孩子
            if (cur.left != null) {
                node.add(cur.left);
            }
            //再看当前结点有没有右孩子
            if (cur.right != null) {
                node.add(cur.right);
            }
        }


    }

}