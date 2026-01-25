
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int[] changer = new int[m+1];
		Arrays.fill(changer, -1);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int favourite = Integer.parseInt(st.nextToken());
			int hate = Integer.parseInt(st.nextToken());
			
			if(changer[hate] == -1) {
				changer[hate] = favourite;
			}
		}
		
		boolean[] visited = new boolean[m+1];
		int current = p;
		int answer = 0;
		
		while (true) {
			if(visited[current]) {
				System.out.println(-1);
				return;
			}
			
			visited[current] = true;
			
			if (changer[current] == -1) {
				break;
			}
			
			current = changer[current];
			answer++;
			
		}
		
		System.out.println(answer);
	}
}
