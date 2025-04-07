import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
	static boolean[][] visited;
	static int[][] map;
	static int cnt = 0;
	static int w, h;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		
						
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int x=0; x<h; x++) {
				for(int y=0; y<w; y++) {
					if(!visited[x][y] && map[x][y] == 1) {
						cnt++;
						dfs(x, y);
					}
				}
			}

			sb.append(cnt + "\n");
			cnt = 0;
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int rx = dx[i] + x;
			int ry = dy[i] + y;
			
			if(rx >= 0 && ry >= 0 && rx < h && ry < w && !visited[rx][ry] && map[rx][ry] == 1) {
				dfs(rx, ry);
			}
		}
	}
	
}
