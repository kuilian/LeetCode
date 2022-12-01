package exercise.class01;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Kui Lian
 * @date 2022/12/1 - 23:27
 * @Description:
 */
public class Code02_CountFiles {


    // 注意这个函数也会统计隐藏文件
    public static int getFileNumber(String folderPath) {
        File root = new File(folderPath);
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        if (root.isFile()) {
            return 1;
        }
        Stack<File> stack = new Stack<>();
        stack.add(root);
        int files = 0;
        while (!stack.isEmpty()) {
            File folder = stack.pop();
            for (File next : folder.listFiles()) {
                if (next.isFile()) {
                    files++;
                }
                if (next.isDirectory()) {
                    stack.push(next);
                }
            }
        }
        return files;
    }

    public static int getFileNumber2(String folderPath) {
        //处理边界
        File root = new File(folderPath);
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        if (root.isFile()) {
            return 1;
        }
        //宽度优先遍历 使用队列
        LinkedList<File> files = new LinkedList<>();
        files.add(root);
        int ans = 0;
        while (!files.isEmpty()) {
            File pop = files.pop();
            for (File file : pop.listFiles()) {
                if (file.isFile()){
                    ans++;
                }
                if (file.isDirectory())
                {
                    files.push(file);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 你可以自己更改目录
        String path = "D:\\学习视频\\算法与数据结构全阶班【完结】【瑞客论坛 www.ruike1.com】\\04-大厂算法和数据结构刷题【完结】";
        System.out.println(getFileNumber(path));
        System.out.println(getFileNumber2(path));
    }


}
