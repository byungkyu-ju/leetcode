class Solution {
    // 연결되지 못하는 값들의 조합
    public long countPairs(int n, int[][] edges) {
		long result = 0;
		List<List<Integer>> graph = generateGraph(n, edges);

		boolean[] isVisited = new boolean[n];

		long notConnectedNodeCount = n;
		for (int i = 0; i < n; i++) {
			if (!isVisited[i]) {
				long connectedCount = dfs(graph, isVisited, i, new int[]{0}); //연결된 수, int 로는 호출한 곳에서 증가시킨 값을 참조할 수 없어 배열로 변경
				notConnectedNodeCount = notConnectedNodeCount - connectedCount; // 전체 개수중 연결되지 않은 개수
				long temp = connectedCount * notConnectedNodeCount; // 누적시킬 남은 노드 수 = 연결된 수 * 남은 연결되지 못한 수
				result = result + temp;
			}
		}
		return result;
	}

	private List<List<Integer>> generateGraph(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for(int[] edge : edges) { //연결
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		return graph;
	}

	private long dfs(List<List<Integer>> graph, boolean[] isVisited, int edgeIdx, int[] count) {
		if (isVisited[edgeIdx]) {
			return count[0];
		}

		isVisited[edgeIdx] = true;
		count[0]++;

		for (int adj : graph.get(edgeIdx)) {
			dfs(graph, isVisited, adj, count);
		}
		return count[0];
	}
}