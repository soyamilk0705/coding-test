import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] ices;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static int m;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ices = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				ices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		int year = 0;
		
		while(true) {
			year++;
			
			int[][] nextIces = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(ices[i][j] > 0) {
						int count = 0;
						
						for(int k=0; k<4; k++) {
							int tempX = dx[k] + i;
							int tempY = dy[k] + j;
							
							if(ices[tempX][tempY] == 0) {
								count++;
							}
						}
						
						nextIces[i][j] = Math.max(0,  ices[i][j] - count);
					}
				}
			}

			ices = nextIces;
		
			int bergs = countIcebergs();
			
			if(bergs == 0) {
				System.out.println(0);
				break;
			} else if(bergs > 1) {
				System.out.println(year);
				break;
			}
			
		}
	}
	
	static int countIcebergs() {
		visited = new boolean[n][m];
		int count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(ices[i][j] > 0 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		return count;
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m && ices[nx][ny] > 0 && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
	
}
