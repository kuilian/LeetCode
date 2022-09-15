package homework;

public class NQueen {
    private static int count = 0;//记录解的个数
    private static final int N = 6;//N皇后 矩阵的尺寸
    private static int[][] arr = new int[N][N];//棋盘数据 我们在二维数组中用1代表棋子 0代表可放入

    public static void main(String[] args) {
        queen(0);//一行一行解决问题
    }

    //递归的解决row角标行 皇后的问题 如果row==N 说明一个解就出来了
    private static void queen(int row) {
        if (row == N) {//当行遍历到N皇后尺寸最大值时返回答案
            count++;
            System.out.println("第" + count + "个解：");
            printArr();
        } else {
            //遍历当前行的列
            for (int col = 0; col < N; col++) {
                if (!isDangerous(row, col)) {
                    //每次放置皇后的时候 都先对该行进行清空
                    for (int c = 0; c < N; c++) {
                        arr[row][c] = 0;
                    }
                    arr[row][col] = 1;
                    queen(row + 1);
                }
            }
        }
    }

    //判断上、左上、右上是否有格子
    private static boolean isDangerous(int row, int col) {
        //向上
        for (int r = row - 1; r >= 0; r--) {
            if (arr[r][col] == 1) {
                return true;
            }
        }
        //左上
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (arr[r][c] == 1) {
                return true;
            }
        }
        //右上
        for (int r = row - 1, c = col + 1; r >= 0 && c < N; r--, c++) {
            if (arr[r][c] == 1) {
                return true;
            }
        }
        return false;
    }

    private static void printArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}