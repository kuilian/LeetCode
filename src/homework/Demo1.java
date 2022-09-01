package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * @author Kui Lian
 * @date 2022/9/1 - 19:30
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        String r1 = isVerse("abcdef", "efabcd");
        System.out.println(r1);
        String verse = isVerse("abcdef", "feabcd");
        System.out.println(verse);
        System.out.println("======================");

        String s = public_String("They are students.", "aeiou");
        System.out.println(s);
        System.out.println("======================");

        int[] count = count(5);
        for (int i : count) {
            System.out.print(i+" ");
        }

    }
    /**
     *求解旋转词问题
    */
    public static String isVerse(String s1, String s2) {
        if (s1.length() < 0 || s2.length() < 0 || s1 == null || s2 == null || !(s1.length() == s2.length())) {
            return "NOT";
        }
        //abcdefabcdef 如果是旋转词 一定是他的子串
        String result = s1 + s1;
        return result.contains(s2) ? "YES" : "NOT";
    }
    /*
    求解删除公共字符问题
     */
    public static String public_String(String s1,String s2) {
        if (s2.length() == 0 || s2 == null) {
            return s1;
        }
        // 1）遍历s2，存到map中 出现过则值为1
        char[] chars = s2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], 1);
        }
        // 2）遍历s1，返回map中没出现过的字符
        char[] chars1 = s1.toCharArray();
        StringBuffer append = new StringBuffer();
        for (int i = 0; i < chars1.length; i++) {
            if (map.get(chars1[i]) == null) {
                append.append(chars1[i]);
            }
        }
        return append.toString();
    }
    /*
    求解门禁系统问题
     */
    public static int[]  count(int count ){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[count];
        int[] help = new int[count];
        Map<Integer, Integer> map = new HashMap<>();
        int index=1;
        for (int i = 0; i < count; i++) {
            //依次输入记录中每位读者的编号
            array[i] = sc.nextInt();
            if (map.get(array[i])==null){
                //存入map结构中 第一次出现计数为1 存入help数组
                map.put(array[i], 1);
                help[i] = 1;
            }else{
                //b不是第一次出现 则计数加一并存入help数组
//                map.put(array[i], index+1);
                help[i] = ++index;
            }
        }
        //结果返回help数组
        return help;
    }
}
