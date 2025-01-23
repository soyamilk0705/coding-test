import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph;
	static int[] colors;
	static final int RED = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int testCase=0; testCase<k; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			colors = new int[v+1];
			
			for(int i=0; i<=v; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph.get(from).add(to);
				graph.get(to).add(from);
			}
			
			boolean rst = false;
			
			for(int i=1; i<=v; i++) {
				if(colors[i] == 0) {
					rst  = bfs(i, RED); 
				}
				
				if(!rst) {
					break;
				}
			}
			
			if(rst) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	static boolean bfs(int start, int color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
	
		colors[start] = color;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next : graph.get(cur)) {
				if(colors[cur] == colors[next]) {
					return false;
				}
				
				if(colors[next] == 0) {
					colors[next] = colors[cur] * -1;
					queue.add(next);
				}
			}
		}
		return true;
	
	}
}
