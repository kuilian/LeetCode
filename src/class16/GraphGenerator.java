package class16;

public class GraphGenerator {

    // matrix 所有的边
    // N*3 的矩阵
    // [weight, from节点上面的值，to节点上面的值]
    //
    // [ 5 , 0 , 7]
    // [ 3 , 0,  1]
    //
    public static Graph createGraph(int[][] matrix) {
        //生成图
        Graph graph = new Graph();
        //获取到每一个结点
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.edges.add(edge);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.edges.add(edge);
            toNode.in++;
            graph.edges.add(edge);
        }
        return graph;
    }

}