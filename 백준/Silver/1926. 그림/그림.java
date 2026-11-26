
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int n, m, max;
	static boolean[][] visited;
	static int[][] draws;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		draws = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				draws[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		Queue<Node> queue = new LinkedList<>();
		int total = 0;
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && draws[i][j] == 1) {
					total++;
					queue.offer(new Node(i, j));
					visited[i][j] = true;
					bfs(queue);
				}
			}
		}
		
		System.out.println(total);
		System.out.println(max);
		
		
		
	}
	
	public static void bfs(Queue<Node> queue) {
		int c = 1;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && draws[nx][ny] == 1) {
					c++;
					queue.offer(new Node(nx, ny));
					visited[nx][ny] = true;
				}
				
			}
			
		}
		
		max = Math.max(c, max);


	}
	
}
