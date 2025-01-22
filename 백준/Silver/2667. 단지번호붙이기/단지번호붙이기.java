import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int cnt, n;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		cnt = 1;
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split("");
			
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				if(map[x][y] == 1 && !visited[x][y]) {
					dfs(x, y);
					result.add(cnt);
					cnt = 1;
				}
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for (int r : result) {
			System.out.println(r);
		}
	}
	
	//10 01 12 21 (1,1)

	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] == 1) {
				cnt++;
				dfs(nx, ny);
			}
		}
		
	}
	
}