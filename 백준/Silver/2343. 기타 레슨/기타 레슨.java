import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] lectures = new int[n];
		int low = 0;
		int high = 0;

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			
			if(low < lectures[i]) {
				low = lectures[i];
			}
			
			high += lectures[i];
		}

		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			int sum = 0;
			int count = 0;
			
			for(int i=0; i<n; i++) {
				if(sum + lectures[i] > mid) {
					count++;
					sum = 0;
				}
				sum += lectures[i];
			}
			
			if(sum != 0) {
				count++;
			}
			
			if(count > m) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(low);
		
	}	
}
