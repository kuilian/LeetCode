package class12;

public class Code03_IsBalanced {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalanced1(Node head) {
		boolean[] ans = new boolean[1];
		ans[0] = true;
		process1(head, ans);
		return ans[0];
	}

	public static int process1(Node head, boolean[] ans) {
		if (!ans[0] || head == null) {
			return -1;
		}
		int leftHeight = process1(head.left, ans);
		int rightHeight = process1(head.right, ans);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			ans[0] = false;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static boolean isBalanced2(Node head) {

		return process(head).isBalanced;

	}

	public static class Info{
		//虽然我只要返回boolean值 但是我得到布尔值需要高度值
		boolean isBalanced ;
		int height;

		public Info(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

	public static Info process(Node head)
	{
		//base case
		if (head==null){
			return new Info(true, 0);
		}
		// 此时 我只要子树的两个信息  一个是否平衡 一个他的高度
		// 假设我能得到这个信息
		Info left = process(head.left);
		Info right = process(head.right);
		//我的子树遵守这个原则 那我也应该遵循这个原则 我也要返回我的info信息
		//怎么获取到我的高度？
		int height = Math.max(left.height , right.height)+1;
		//怎么获取到我是否平衡?
		boolean isBalanced = true;
		//不平衡的情况
		if (Math.abs(left.height-right.height)>1){
			isBalanced = false;
		}
		// 左右子树不平衡
		if (!left.isBalanced){
			isBalanced = false;
		}
		if (!right.isBalanced){
			isBalanced = false;
		}

		return new Info(isBalanced,height);
	}

	
	
	
	
	

	// for test
	public static Node generateRandomBST(int maxLevel, int maxValue) {
		return generate(1, maxLevel, maxValue);
	}

	// for test
	public static Node generate(int level, int maxLevel, int maxValue) {
		if (level > maxLevel || Math.random() < 0.5) {
			return null;
		}
		Node head = new Node((int) (Math.random() * maxValue));
		head.left = generate(level + 1, maxLevel, maxValue);
		head.right = generate(level + 1, maxLevel, maxValue);
		return head;
	}

	public static void main(String[] args) {
		int maxLevel = 5;
		int maxValue = 100;
		int testTimes = 1000000;
		for (int i = 0; i < testTimes; i++) {
			Node head = generateRandomBST(maxLevel, maxValue);
			if (isBalanced1(head) != isBalanced2(head)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("finish!");
	}

}