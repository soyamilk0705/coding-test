import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int len = Integer.parseInt(br.readLine());
		
		for(int i=0; i<len; i++) {
			int n = Integer.parseInt(br.readLine());
			HashSet<Integer> set = new HashSet<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			int m = Integer.parseInt(br.readLine());
	
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				boolean isEquals = set.contains(Integer.parseInt(st.nextToken()));
				sb.append(isEquals ? 1 : 0).append("\n");
			}
			
			
		}
		
		System.out.println(sb);
		
	}

}
