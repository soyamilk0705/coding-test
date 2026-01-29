
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static boolean[] visited;
	static int[][] family;
	static int end;
	static int n;
	static int answer = -1;
	
	static void DFS(int p, int L) {
		visited[p] = true;
		
		if(p == end) {
			answer = L;
			return;
		} 
			
		for(int i=1; i<=n; i++) {
			if(!visited[i] && family[p][i] == 1) {
				DFS(i, L+1);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		family = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			family[x][y] = 1;
			family[y][x] = 1;
		}
		
		
		DFS(start, 0);
		
		
		System.out.println(answer);
	}
}

