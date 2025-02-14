import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		int[][] times = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times, (o1, o2) ->{
			return o1[0] - o2[0];
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(times[0][1]);
		
		
		for(int i=1; i<n; i++) {
			if(pq.peek() <= times[i][0]) {
				pq.poll();
			}
			pq.add(times[i][1]);
		}
		
		System.out.println(pq.size());
	}
	
}
