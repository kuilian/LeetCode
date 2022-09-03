package class11;

import java.util.ArrayList;
import java.util.List;

// 本题测试链接：https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
public class Code03_EncodeNaryTreeToBinaryTree {

    // 提交时不要提交这个类
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    // 提交时不要提交这个类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Codec {
        /**
         * 将N叉树变为二叉树
         *
         * @param root
         * @return
         */
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            //N叉树的头结点也是二叉树的头结点
            TreeNode treeNode = new TreeNode(root.val);
            //将孩子结点放到二叉树的左子树的右边界
            treeNode.left = en(root.children);
            return treeNode;
        }

        private TreeNode en(List<Node> children) {
            //创建第一个父节点变量 和 当前结点变量
            TreeNode head = null;
            TreeNode cur = null;
            //遍历所有孩子结点
            for (Node child : children) {
                //只有第一个孩子结点放到左子树 剩下的当左子树的右边界
                TreeNode treeNode = new TreeNode(child.val);
                if (head == null) {
                    head = treeNode;
                } else {
                    //为什么不是head.right  head是整颗二叉树头结点的左子树结点 cur才是用于构建子树的结点变量
                    cur.right = treeNode;
                }
                cur = treeNode;
                cur.left = en(children);
            }
            return head;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }

        /*
        左树就是children
         */
        public List<Node> de(TreeNode root) {
//         root就是长兄  他的兄弟都在长兄结点的右边界上
            List<Node> children = new ArrayList<>();
            while (root != null) {
                //先把自己创建好
                //那当前结点的孩子 也在他的左树上
                Node cur = new Node(root.val, de(root.left));
                //他的兄弟都在他的右边界上
                children.add(cur);
                root = root.right;
            }
            return children;

        }

    }
}