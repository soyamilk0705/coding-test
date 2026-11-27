
import java.io.*;
import java.util.*;


public class Main {
	static int n, m;
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] draws = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		int total = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				draws[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && draws[i][j] == 1) {
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
					total++;
					bfs(draws, visited, queue);
				}
			}
		}
		
		System.out.println(total);
		System.out.println(max);
		
	}
	
	
	
	public static void bfs(int[][] draws, boolean[][] visited, Queue<int[]> queue) {
		int cnt = 1;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && draws[nx][ny] == 1) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
			
		}
		
		max = Math.max(cnt, max);
	}
}
