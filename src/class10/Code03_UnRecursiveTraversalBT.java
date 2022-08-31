package class10;

import java.util.Stack;

public class Code03_UnRecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void pre(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            //把head放入栈中
            Stack<Node> s1 = new Stack<>();
            s1.add(head);
            //栈不为空时 栈顶元素为cur
            while (!s1.isEmpty()) {
                //栈不为空 则弹出栈顶元素 判断他有没有右子树 有则进栈 再判断有没有做字数 有则进栈
                head = s1.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    s1.push(head.right);
                }
                if (head.left != null) {
                    s1.push(head.left);
                }

            }
            System.out.println();


        }
    }

    /**
     * 中序遍历
     *
     * @param cur
     */
    public static void in(Node cur) {
        System.out.print("in-order: ");
        if (cur != null) {
            Stack<Node> s1 = new Stack<>();
            while (!s1.isEmpty() || cur != null) {
                if (cur != null) {
                    s1.push(cur);
                    cur = cur.left;
                } else {
                    cur = s1.pop();
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }

            }

        }
        System.out.println();
    }

    /**
     * @return void
     * @Date 20:31 2022/8/31
     * @Param [head]
     * @Description: 后序遍历
     */
    public static void pos1(Node head) {
        System.out.print("pos-order: ");
        //两个栈 第一个栈跟先序遍历差不多 但是先放左子树进栈 这样栈中顺序就是 头 右 左  此时再放进另外一个栈弹出来 顺序就是后序遍历
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.add(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.add(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
            System.out.println();

        }
    }

    public static void pos2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }

}