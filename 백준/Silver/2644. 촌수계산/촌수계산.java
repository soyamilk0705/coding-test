
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		List<List<Integer>> family = new LinkedList<>();
			
		for(int i=0; i<=n; i++) {
			family.add(new ArrayList<>());
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			family.get(x).add(y);
			family.get(y).add(x);
		}
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		
		queue.offer(start);
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			for(int x : family.get(v)) {
				if(dist[x] == -1) {
					dist[x] = dist[v] + 1;
					queue.offer(x);
				}
				
			}
			
		}
		
		System.out.println(dist[end]);
	}
}

