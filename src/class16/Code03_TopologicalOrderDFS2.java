package class16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// OJ链接：https://www.lintcode.com/problem/topological-sorting
public class Code03_TopologicalOrderDFS2 {

    // 不要提交这个类
    public static class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    // 提交下面的
    public static class Record {
        public DirectedGraphNode node;
        public long nodes;//点次

        public Record(DirectedGraphNode n, long o) {
            node = n;
            nodes = o;
        }
    }

    public static class MyComparator implements Comparator<Record> {

        @Override
        public int compare(Record o1, Record o2) {
            return o1.nodes == o2.nodes ? 0 : (o1.nodes > o2.nodes ? -1 : 1);
        }
    }

    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        //建立缓存
        HashMap<DirectedGraphNode, Record> order = new HashMap<>();
        for (DirectedGraphNode cur : graph) {
            f(cur, order);
        }
        ArrayList<Record> records = new ArrayList<>();
        for (Record value : order.values()) {
            //把缓存里的都加到数组
            records.add(value);
        }
        //根据点次排序
        records.sort(new MyComparator());
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        for (Record an : records) {
            ans.add(an.node);
        }
        return ans;
    }

    // 当前来到cur点，请返回cur点所到之处，所有的点次！ dp
    // 返回（cur，点次）
    // 缓存！！！！！order
    //  key : 某一个点的点次，之前算过了！
    //  value : 点次是多少
    public static Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode, Record> order) {
        if (order.containsKey(cur)) {
            return order.get(cur);
        }
        // cur的点次之前没算过！
        long nodes = 0;
        for (DirectedGraphNode node : cur.neighbors) {
            nodes += f(node, order).nodes;
        }
        Record record = new Record(cur, nodes + 1);
        order.put(cur, record);
        return record;
    }

}