import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inputs = new int[n];
		
		for(int i=0; i<n; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputs);
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			if (sum + 1 < inputs[i]) {
				break;
			}
			
			sum += inputs[i];
		}
		
		System.out.println(sum + 1);
	
	}
}
