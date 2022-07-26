package homework;

import java.util.Scanner;

/**
 * @author Kui Lian
 * @date 2022/9/29 - 15:53
 * @Description:
 */
public class Demo_fish {

    public static void main(String[] args) {
        //接受输入参数
        Scanner scanner = new Scanner(System.in);
        int minSize = scanner.nextInt(); //新放入鱼范围的最小值
        int maxSize = scanner.nextInt();//新放入鱼范围的最大值
        int inNumber = scanner.nextInt();//鱼缸里面已经有鱼的数量
        int[] inFishSize = new int[inNumber]; //定义一个数组
        for (int i = 0; i < inNumber; i ++) {
            inFishSize[i] = scanner.nextInt();//初始化已经有的鱼的大小inFishSize[i]
        }

        int canPut = 0;//可以放进鱼的种类数

        for (int i = minSize; i <= maxSize; i ++) { //遍历输入的范围，逐个查看每中大小的鱼是否可以放进去
            boolean willBeEaten = false; //是否被吃，true 被吃。
            for (int j = 0; j < inNumber; j ++) {
                if ((10 * i >= inFishSize[j] && 2 * i <= inFishSize[j])
                        || (i >= inFishSize[j] * 2 && i <= inFishSize[j] * 10)) {
                    willBeEaten = true;
                    break; //一旦发现此鱼不能放进去，break，跳出循环，避免多余的检查
                }
            }
            //如果这条鱼可以不被鱼缸中其他鱼吃。或者被吃。则canPut++
            if (!willBeEaten) {
                canPut ++;
            }
        }
        System.out.println(canPut);
    }
}
