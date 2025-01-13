import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		
		for(int i=0; i<len; i++) {
			StringBuilder sb = new StringBuilder();
			
			int n = Integer.parseInt(br.readLine());
			int[] list = new int[n+1];
			

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				list[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(list);
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				int left = 0;
				int right = n;
				int val = Integer.parseInt(st.nextToken());
				boolean find = false;
				
				while(left <= right) {
					int mid = (left + right) / 2;
					
					if(list[mid] == val) {
						find = true;
						break;
					} else if(list[mid] < val) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				
				sb.append(find ? 1 : 0).append("\n");
			}
			
			System.out.print(sb);
			
		}
		
	}

}
