import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] visited = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n == k) {
			System.out.println(0);
		} else {
			bfs(n);
		}
	}
	
	static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		visited[num] = 1;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=0; i<3; i++) {
				int next;
				
				if(i == 0) {
					next = temp + 1;
				} else if(i == 1) {
					next = temp - 1;
				} else {
					next = temp * 2;
				}
				
				if (next == k) {
					System.out.println(visited[temp]);
					return;
				}
				
				if(next >=0 && next < visited.length && visited[next] == 0) {
					queue.offer(next);
					visited[next] = visited[temp] + 1;
				}
			}
		}
	}
}
