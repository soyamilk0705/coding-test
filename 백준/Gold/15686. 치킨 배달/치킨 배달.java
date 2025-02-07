import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] cities;
	static boolean[] visited;
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cities = new int[n][n];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				cities[i][j] = Integer.parseInt(st.nextToken());
				
				if(cities[i][j] == 1) {
					house.add(new int[]{i, j});
				} else if(cities[i][j] == 2) {
					chicken.add(new int[]{i, j});
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		
		back(0, 0);
		System.out.println(result);
	
	}
	
	static void back(int start, int cnt) {
		if(cnt == m) {
			int answer = 0;
			
			for(int i=0; i<house.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j<chicken.size(); j++) {
					if(visited[j]) {
						int distance = Math.abs(house.get(i)[0] - chicken.get(j)[0])
								+ Math.abs(house.get(i)[1] - chicken.get(j)[1]);
						
						temp = Math.min(temp, distance);
					}
				}
				answer += temp;
			}
			
			result = Math.min(result, answer);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			visited[i] = true;
			back(i+1, cnt+1);
			visited[i] = false;
		}
	}
	
}
