import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[] dVisited;
	static boolean[] bVisited;
	static int[][] graph;
	static StringBuilder dfsResult = new StringBuilder();
	static StringBuilder bfsResult = new StringBuilder();
	
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		dVisited = new boolean[n+1];
		bVisited = new boolean[n+1];
		graph = new int[n+1][n+1];
		
		
		for(int i=1; i<m+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		
		dfs(start);
		bfs(start);
		
		
		System.out.println(dfsResult.toString());
		System.out.println(bfsResult.toString());
	}
	
	static void dfs(int start) {
		dVisited[start] = true;
		dfsResult.append(start).append(" ");
		
		for(int i=1; i<=n; i++) {
			if(graph[start][i] == 1 && !dVisited[i]) {
				dfs(i);
			}
			
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		bVisited[start] = true;
		
		while(!queue.isEmpty()) {
			start = queue.poll();
			bfsResult.append(start).append(" ");
			
			for(int i=1; i<=n; i++) {
				if(graph[start][i] == 1 && !bVisited[i]) {
					queue.offer(i);
					bVisited[i] = true;
				}
				
			}
			
		}
	}
	
	
}