import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(a > b) {
			int swap = a;
			a = b;
			b = swap;
		}
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for(int j=s; j<=e; j++) {
				dp[j] = -1;
			}
		}
			
		for(int i=1; i<=n; i++) {
			if(dp[i] == -1) {
				continue;
			}
			
			if(i < a) {
				dp[i] = -1;
			} else if(i < b) {
				if(dp[i-a] == -1) {
					dp[i] = -1;
				} else {
					dp[i] = dp[i-a] + 1;
				}
			} else if(dp[i-a] == -1 && dp[i-b] == -1) {
				dp[i] = -1;
			} else if(dp[i-a] == -1) {
				dp[i] = dp[i-b] + 1;
			} else if(dp[i-b] == -1) {
				dp[i] = dp[i-a] + 1;
			} else {
				dp[i] = Math.min(dp[i-a], dp[i-b]) + 1;
			}
			
			
			
		}
		

		System.out.println(dp[n]);
	}
	
	
	
}
