import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		
		int cnt = 0;
		
		if(n == 1) {
			cnt = 1;
		} else if(n == 2) {
			cnt = Math.min(4, (m+1) / 2);
		} else if(m < 7) {
			cnt = Math.min(4,  m);
		} else if(m >= 7) {
			cnt = m - 2;
		}
		
		System.out.println(cnt);

		
	}
}
