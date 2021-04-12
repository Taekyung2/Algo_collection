package algorithm_skill;

import java.util.ArrayList;
import java.util.Arrays;

public class Prim {
	static class Pair {
		int first, second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static int V = 100;
	@SuppressWarnings("unchecked")
	static ArrayList<Pair>[] adj = new ArrayList[100];
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++)
			adj[i] = new ArrayList<Pair>();
	}
	
	static int prim(ArrayList<Pair> selected) {
		selected.clear();
		boolean[] added = new boolean[V];
		int[] minWeight = new int[V];
		int[] parent = new int[V];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		int ret = 0;
		minWeight[0] = parent[0] = 0;
		for(int iter = 0; iter < V; iter++) {
			//다음에 트리에추가할 정점 u를 찾는다.
			int u = -1;
			for(int v = 0; v < V; v++)
				if(!added[v] && (u == -1 || minWeight[u] > minWeight[v]))
					u = v;
			if(parent[u] != u)
				selected.add(new Pair(parent[u], u));
			ret += minWeight[u];
			added[u] = true;
			
			for(int i = 0; i < adj[u].size(); i++) {
				int v = adj[u].get(i).first, weight = adj[u].get(i).second;
				if(!added[v] && minWeight[v] > weight) {
					parent[v] = u;
					minWeight[v] = weight;
				}
			}
		}
		return ret;
	}
}
