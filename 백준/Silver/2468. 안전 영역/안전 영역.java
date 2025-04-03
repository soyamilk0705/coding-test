import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static boolean[][] visited;
	static int[][] region;
	static int maxValue = Integer.MIN_VALUE;
	static List<Integer> result = new ArrayList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int answer = 1;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		region = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				int value = Integer.parseInt(st.nextToken());
				region[i][j] = value;
				maxValue = Math.max(maxValue, value);
			}
				
		}
		
		for(int h=0; h<=maxValue; h++) {
			visited = new boolean[N][N];
			cnt = 0;
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					if(!visited[x][y] && region[x][y] > h) {
						cnt++;
						dfs(x, y, h);
					}
				}
			}
			
			answer = Math.max(answer, cnt);
		}
	
		System.out.println(answer);

	}
	
	static void dfs(int x, int y, int flag) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && region[nx][ny] > flag) {
				dfs(nx, ny, flag);
			}
		}
		
	}
	
	
}
