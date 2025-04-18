import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			dp[i] = dp[i-1];
			
			if(i-m < 0) {
				continue;
			}
			
			dp[i] += dp[i-m];
			dp[i] %= 1000000007;
		}
		
		System.out.println(dp[n]);
		
	}
	
}
