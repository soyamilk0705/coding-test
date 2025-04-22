import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] graph;
	static boolean[] visited;
	static long maxDistance = 0;
	
	static class Node {
		int to;
		int weight;
		
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
			graph[v].add(new Node(u, w));
		}
		
		dfs(1, 0);
		
		System.out.println(maxDistance);
		
		
	}
	
	static void dfs(int now, long distance) {
		visited[now] = true;
		maxDistance = Math.max(maxDistance, distance);
		
		for(Node next : graph[now]) {
			if(!visited[next.to]) {
				dfs(next.to, distance + next.weight);
			}
		}
	}
	
}
