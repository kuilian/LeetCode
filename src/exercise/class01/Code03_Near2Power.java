package exercise.class01;

public class Code03_Near2Power {

    // 已知n是正数
    // 返回大于等于，且最接近n的，2的某次方的值
    public static final int tableSizeFor(int n) {
        //兼顾给定的数本来就是二的某次方
        //int 类型只有32位 如果long类型就多一步
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n+1;
    }

    public static void main(String[] args) {
        int cap = 120;
        System.out.println(tableSizeFor(cap));
    }

}