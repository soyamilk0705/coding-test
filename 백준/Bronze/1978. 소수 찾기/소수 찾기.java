
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 1) {
				continue;
			}
			
			int cnt = 0;
			for(int j=2; j<num-1; j++) {
				if (num % j == 0) {
					cnt++;
					break;
				}
			}
			
			if(cnt == 0) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
}
