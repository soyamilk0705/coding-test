
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static int answer, m, n;
	static boolean[][] visited;
	static int[] xDis = {-1, 1, 0, 0};
	static int[] yDis = {0, 0, -1, 1};
	
	static void dfs(int[][] arr, int x, int y) {
		for(int i=0; i<4; i++) {
			int xTmp = x + xDis[i];
			int yTmp = y + yDis[i];
			
			if(xTmp < m && xTmp >= 0 && yTmp < n && yTmp >= 0 && !visited[xTmp][yTmp]) {
				visited[xTmp][yTmp] = true;
				if(arr[xTmp][yTmp] == 1) {
					dfs(arr, xTmp, yTmp);
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] arr;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			arr = new int[m][n];
			visited = new boolean[m][n];
			answer = 0;
			
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			
			for(int p=0; p<m; p++) {
				for(int q=0; q<n; q++) {
					if(!visited[p][q] && arr[p][q] == 1) {
						answer++;
						visited[p][q] = true;
						dfs(arr, p, q);
					}
					
				}
			}
			sb.append(answer + "\n");
		}
		
		System.out.println(sb.toString());
	}
}

