
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[n+1];
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			String name = br.readLine();
			arr[i] = name;
			map.put(name, i);
		}
		
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			
			if(Character.isDigit(str.charAt(0))) {
				sb.append(arr[Integer.parseInt(str)] + "\n");
			} else {
				sb.append(map.get(str) + "\n") ;
				
			}
			
		}
		
		System.out.print(sb);
		
		
	}
}
