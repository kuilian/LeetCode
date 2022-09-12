package class16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

// OJ链接：https://www.lintcode.com/problem/topological-sorting
public class Code03_TopologicalOrderDFS1 {

	// 不要提交这个类
	public static class DirectedGraphNode {
		public int label;
		public ArrayList<DirectedGraphNode> neighbors;

		public DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	}

	public static class Record{
		public DirectedGraphNode directedGraphNode;
		public int deep;

		public Record(DirectedGraphNode directedGraphNode, int deep) {
			this.directedGraphNode = directedGraphNode;
			this.deep = deep;
		}
	}
	public static class MyComparator implements Comparator<Record> {

		@Override
		public int compare(Record o1, Record o2) {
			return o2.deep-o1.deep;
		}
	}
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		// write your code here
		ArrayList<Record> recordArr = new ArrayList<>();

		//生成缓存表先
		HashMap<DirectedGraphNode, Record> hashMap = new HashMap<>();

		for (DirectedGraphNode cur : graph){
			f(cur, hashMap);
		}
		//得到了缓存表
		for (Record record:hashMap.values()){
			recordArr.add(record);
		}
		//进行排序
		recordArr.sort(new MyComparator());
		ArrayList<DirectedGraphNode> directedGraphNodes = new ArrayList<>();
		for (Record cur: recordArr){
			directedGraphNodes.add(cur.directedGraphNode);
		}
		return directedGraphNodes;
	}
	public static Record f(DirectedGraphNode node,HashMap<DirectedGraphNode,Record> order){
		if (order.containsKey(node)){
			return order.get(node);
		}
		//没有在里面的
		int deep= 0;
		for (DirectedGraphNode cur :node.neighbors){
			deep= Math.max( f(cur,order).deep,deep);
			//深度是最大值
		}
		Record record = new Record(node, deep + 1);
		order.put(node,record);
		return record;

	}
}