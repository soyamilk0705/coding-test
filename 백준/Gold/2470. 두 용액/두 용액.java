import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		

		int[] solutions = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solutions);
		
		
		// -99 -2 -1 4 98
		
		int low = 0;
		int high = n - 1;
		
		int gap = Integer.MAX_VALUE;
		int answer1 = 0;
		int answer2 = 0;
		
		int temp;
		int sum;
		
		while(low < high) {
			sum = solutions[low] + solutions[high];
			temp = Math.abs(sum);
			
			if(temp < gap) {
				gap = temp;
				answer1 = solutions[low];
				answer2 = solutions[high];
				
			}
			
			if(sum > 0) {
				high--;
			} else {
				low++;
			}
			
			
		}
		
		System.out.println(answer1 + " " + answer2);
		
	}
	
	
}