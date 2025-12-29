
import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1764

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<String> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		
		
		for(int i=0; i<n+m; i++) {
			String tmp = br.readLine();
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key) > 1) {
				answer.add(key);
			}
		}
		
		Collections.sort(answer);
		
		System.out.println(answer.size());
		for(String s : answer) {
			System.out.println(s);
		}
		

	}
}
