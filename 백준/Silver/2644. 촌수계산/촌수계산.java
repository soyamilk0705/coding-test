
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static boolean[] visited;
	static int[][] family;
	static int end;
	static int n, answer = 0;
	
	static void DFS(int p) {
		if(p == end) {
			visited[end] = true;
			return;
		} else {
			for(int i=1; i<=n; i++) {
				if(!visited[p] && family[p][i] == 1) {
					visited[p] = true;
					answer++;
					DFS(i);
				
					if(visited[end]) {
						return;
					} else {
						answer--;
						visited[p] = false;
					}
					
				}
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
		
		
		DFS(start);
		
		if(!visited[end]) {
			answer = -1;
		}
		
		System.out.println(answer);
	}
}

