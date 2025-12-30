
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		int maxValue = 0;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			if(str.length() >= m) {
				map.put(str, map.getOrDefault(str, 0)+1);
				maxValue = Math.max(maxValue, map.get(str));
			}
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
	
		list.sort((a, b) -> {
			if(a.getValue() != b.getValue()) {
				return b.getValue() - a.getValue();
			}
			
			if(a.getKey().length() != b.getKey().length()) {
				return b.getKey().length() - a.getKey().length();
			}
			
			return a.getKey().compareTo(b.getKey());
		});
	
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, Integer> e : list) {
		    sb.append(e.getKey()).append('\n');
		}

		System.out.print(sb.toString());
	}
}