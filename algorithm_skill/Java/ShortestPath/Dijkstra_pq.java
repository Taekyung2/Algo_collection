package algorithm_skill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Dijkstra {
	static class Edge implements Comparable<Edge> {
		int to, cost;
		
		public Edge(int to, int cost) {
		    this.to = to;
		    this.cost = cost;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}

	static ArrayList<Integer> dijkstra(int src) {
		ArrayList<Integer> dist = new ArrayList<>(V);
		Collections.fill(dist, Integer.MAX_VALUE);
		dist.set(src, 0);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, 0));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int here = p.to;
			int cost = -p.cost;
			if(dist.get(here) < cost) continue;
			
			for(int i = 0; i < adj[here].size(); ++i) {
				int there = adj[here].get(i).to;
				int nextDist = cost + adj[here].get(i).cost;
				
				if(dist.get(there) > nextDist) {
					dist.set(there, nextDist);
					pq.add(new Pair(there, -nextDist));
				}
			}
		}
		return dist;
	}
}