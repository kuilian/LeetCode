package homework;

/**
 * @author Kui Lian
 * @date 2022/10/24 - 11:32
 * @Description:
 */
public class Demo9 {
    static int[]w={ 0, 5, 30, 10, 1, 20, 40, 20}; // 4个集装箱，w[0]放弃
    static int n = w.length - 1;//集装箱的个数
    static int bestw = 0;//当前的最优值
    static int cw = 0;//当前轮船的装载量
    static int c =58;//轮船最大的核载量
    static int r = 0;//剩余集装箱的重量
    static int []bestx=new int [n+1];//用来存放当前的最优解
    static int x[]=new int[n+1];//当前解
    public static void main(String[] args) {
        for (int i = 1; i <= n; i++) {//刚开始时,剩余的集装箱重量是所有集装箱的重量
            r += w[i];
        }
        int tempR=r;//临时变量,求最优解时要用到

        cw = 0;//重置当前轮船的装载量
        r = tempR;//重置剩余集装箱的重量
        f2(1);  //f2是用来求最优解的,和f稍有不同
        for(int i=1;i<=n;i++){
            System.out.print(bestx[i]+" ");
        }
    }

    private static void f2(int i) {
        //搜索第i层结点
        if (i > n) { //到达叶结点
            for(int j=1;j<=n;j++){
                bestx[j]=x[j];
            }
            bestw = cw;
            return;
        }
        //搜索子树
        r -= w[i];
        if (cw + w[i] <= c) { //搜索左子树
            x[i]=1;
            cw += w[i];
            f2(i + 1);
            cw -= w[i];
        }
        if (cw + r >= bestw) { //搜索右子树(特别注意,这里是>=号,而在f()方法的这里可以不需要).
            x[i]=0;
            f2(i + 1);
        }
        r += w[i];
    }

    private static void f(int i) {
        //搜索第i层结点
        if (i > n) { //到达叶结点
            bestw = cw;
            return;
        }
        //搜索子树
        r -= w[i];
        if (cw + w[i] <= c) { //搜索左子树
            cw += w[i];
            f(i + 1);
            cw -= w[i];
        }
        if (cw + r > bestw) { //搜索右子树
            f(i + 1);
        }
        r += w[i];
    }
}
