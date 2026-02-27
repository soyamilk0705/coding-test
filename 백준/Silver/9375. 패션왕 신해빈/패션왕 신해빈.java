import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	

	public static int Combination(int n, int r) {
		if(r < 0 || r > n) {
			return 0;
		}
		r = Math.min(r, n - r);
		
		int result = 1;
		
		for(int i=0; i<r; i++) {
			result = result * (n-i) / (i+1);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> clothes = new HashMap<>();
			
			StringTokenizer st;
			
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				
				clothes.put(type, clothes.getOrDefault(type, 0) + 1);
			}
			
			int answer = 1;
			
			for(int count : clothes.values()) {
				answer *= (count+1);
			}
			
			sb.append(answer - 1).append("\n");
		}
		System.out.print(sb);
		
	}
}
