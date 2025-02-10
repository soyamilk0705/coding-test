import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

		if(n == 0) {
			System.out.println(0);
			return;
		} 
		
		long cnt = 1;
		long sum = 1;
		
		while(sum < n) {
			sum *= 2;
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
}