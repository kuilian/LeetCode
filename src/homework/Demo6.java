package homework;

import java.util.Scanner;

/**
 * @author Kui Lian
 * @date 2022/9/29 - 14:58
 * @Description:
 */
public class Demo6 {
    public static void main(String[] args) {
        Character[][] characters = new Character[][]{
                {'B', 'W', 'W'},
                {'B', 'C', 'C'},
                {'B', 'C', 'B'}
        };
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Character[][] characters = new Character[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                characters[i][j]  = sc.next().charAt(0);
//            }
//        }
        int checkerboard = checkerboard(3, characters);
        System.out.println("checkerboard = " + checkerboard);
    }

    //找出棋盘中某一列中拥有相同颜色的最大的区域去涂画 暴力
    public static int checkerboard(int n, Character[][] arr) {
        if (n == 0 || arr.length == 0 || arr == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int length = 0;
            for (int j = 1; j < n; j++) {
                if (arr[i][j - 1].equals(arr[i][j])) {
                    length += 1;
                }
            }
            max = Math.max(max, length+1);
        }
        return max;
    }


}
