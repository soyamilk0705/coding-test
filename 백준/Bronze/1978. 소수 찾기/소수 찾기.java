
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 실버5
// https://www.acmicpc.net/problem/20546

// 실버4
// https://www.acmicpc.net/problem/10828


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num < 2) {
				continue;
			}
			
			boolean isPrime = true;
			
			for(int j=2; j*j<=num; j++) {
				if (num % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
}
