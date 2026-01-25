
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static int n, m, answer = 0;
	static boolean[][] nodes;
	static boolean[] visited;
	
	static void DFS(int v) {
		visited[v] = true;
		
		for(int i=1; i<=n; i++) {
			if(nodes[v][i] && !visited[i]) {
				DFS(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		nodes = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			nodes[x][y] = true;
			nodes[y][x] = true;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				answer++;
				DFS(i);
			}
		}
		
		System.out.println(answer);
	}
}

