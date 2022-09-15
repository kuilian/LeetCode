package homework;

import java.util.Scanner;
public class N_Queen {
	public static void main(String[] args) {
		Scanner nscan = new Scanner(System.in);
		int n = nscan.nextInt();
		//用一维数组表示棋盘，下标为行，值为每一行皇后所在的列
		int a[] = new int[n];
		Q q = new Q();
		q.digui(a, 0, n);
	}
}

class Q {
	//k代表此时要摆放皇后所在的行数，也就是说0到k-1行已经摆好了
	public void digui(int a[], int k, int n) {
		if (k == n) {
			//全都放好了，输出结果
			for (int row : a) {
				System.out.print(row + " ");
			}
			System.out.println();
		}
		//i代表第k行的列数
		for (int i = 0; i < n; i++) {
			int j;
			//看0 - k-1行有没有冲突的
			for (j = 0; j < k; j++) {
				if (a[j] == i || Math.abs(j-k) == Math.abs(a[j]-i)) {
					break;
				}
			}
			//跟前面的皇后都没有冲突，可以放置
			if (j == k) {
				a[k] = i;
				digui(a, k+1, n); //放置下一枚皇后
			}
		}
	}
}