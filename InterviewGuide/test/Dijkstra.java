package test;



	import java.util.*;

	/**
	 * @program: MyCode
	 * @description: �ҿ�˹�����㷨
	 * �㷨���裺1.�ж��Ƿ���δ����Ľڵ�
	 * 2.���У�����������������Ľڵ�
	 * 3.�����ýڵ������ھӲ������俪��
	 * 4.������ھӵĿ��������£�ͬʱ���¸��ڵ�
	 * 5.�ýڵ���Ϊ�Ѵ���
	 * 6.�ظ���1��
	 * @author: like
	 * @create: 2018-04-22 10:49
	 **/
	public class Dijkstra {
	    //����û����֪����·���ı��
	    private static int NOWAY_SIGN = Integer.MAX_VALUE;
	    private static final String START = "start";
	    private static final String END = "end";

	    public void getMinStep(String start, String end, Map<String, Map<String, Integer>> graph) {
	        //���ڵ�����ٻ���
	        Map<String, Integer> costs = graph.get(start);
	        //���ڵ����ٻ���ʱ�ĸ��ڵ�
	        Map<String, String> parents = new HashMap<String, String>();
	        //�Ѵ���Ľڵ�
	        HashSet<String> processed = new HashSet<String>();
	        //��δ����Ľڵ����ҵ�������С�Ľڵ�
	        String node = findLowestCostNode(costs, processed);
	        while (node != null && graph.get(node) != null) {
	            int cost = costs.get(node);
	            //������ǰ�ڵ�������ھ�
	            Iterator iterator = graph.get(node).entrySet().iterator();
	            while (iterator.hasNext()) {
	                Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
	                //ͨ��node�ڵ㵽�ýڵ����С����
	                int newCost = cost + entry.getValue();
	                //���´�start���ýڵ����С����
	                if (!costs.containsKey(entry.getKey()) || costs.get(entry.getKey()) > newCost) {
	                    costs.put(entry.getKey(), newCost);
	                    parents.put(entry.getKey(), node);
	                }
	            }
	            //�ýڵ�����Ѵ���
	            processed.add(node);
	            //�ҳ���ǰ��С���ĵĽڵ�
	            node = findLowestCostNode(costs, processed);
	        }
	        printPath(parents, costs.get(END));
	    }

	    public void initParents(String start, Map<String, Integer> startGraph, Map<String, String> parents) {
	        Iterator iterator = startGraph.entrySet().iterator();
	        while (iterator.hasNext()) {
	            Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
	            parents.put(entry.getKey(), start);
	        }
	    }

	    /**
	     * �ҳ�δ����ڵ���������С�Ľڵ�
	     *
	     * @param costs
	     * @param processed
	     * @return
	     */
	    public String findLowestCostNode(Map<String, Integer> costs, HashSet<String> processed) {
	        int lowestCost = NOWAY_SIGN;
	        String lowestCostNode = null;
	        Iterator iterator = costs.entrySet().iterator();
	        while (iterator.hasNext()) {
	            Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
	            if (!processed.contains(entry.getKey()) && entry.getValue() < lowestCost) {
	                lowestCost = entry.getValue();
	                lowestCostNode = entry.getKey();
	            }
	        }
	        return lowestCostNode;
	    }

	    public void printPath(Map<String, String> parents, int cost) {
	        Stack<String> stack = new Stack<String>();
	        String parent = parents.get(END);
	        while (parent != null) {
	            if (START.equalsIgnoreCase(parent)) {
	                stack.push(START);
	                break;
	            }
	            stack.push(parent);
	            parent = parents.get(parent);
	        }
	        StringBuffer path = new StringBuffer();
	        while (!stack.empty()) {
	            String node = stack.pop();
	            if (path.length() != 0) {
	                path.append("->");
	            }
	            path.append(node);
	        }
	        System.out.println("����·�ߣ�" + START + "->" + path.toString() + "->" + END);
	        System.out.println("�俪��Ϊ��" + cost);
	    }

	    public static void main(String[] args) {
	        Map<String, Map<String, Integer>> graph = new HashMap<String, Map<String, Integer>>();
	        Map<String, Integer> start = new HashMap<String, Integer>();
	        start.put("A", 5);
	        start.put("B", 2);
	        graph.put(START, start);
	        Map<String, Integer> a = new HashMap<String, Integer>();
	        a.put("C", 4);
	        a.put("D", 2);
	        graph.put("A", a);
	        Map<String, Integer> b = new HashMap<String, Integer>();
	        b.put("A", 8);
	        b.put("D", 7);
	        graph.put("B", b);
	        Map<String, Integer> c = new HashMap<String, Integer>();
	        c.put("D", 6);
	        c.put(END, 3);
	        graph.put("C", c);
	        Map<String, Integer> d = new HashMap<String, Integer>();
	        d.put(END, 1);
	        graph.put("D", d);
	        Dijkstra dijkstra = new Dijkstra();
	        dijkstra.getMinStep(START, END, graph);
	    }
	
}