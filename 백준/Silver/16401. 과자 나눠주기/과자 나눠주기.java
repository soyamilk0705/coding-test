import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] snack = new int[n];

		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snack);
		
		int left = 1;
		int right = snack[n-1];
		
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			
			for(int i=0; i<n; i++) {
				if(snack[i] >= mid) {
					cnt += snack[i] / mid;
				}
			}
			
			if(cnt >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
		
	}
}
