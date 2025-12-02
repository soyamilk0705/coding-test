
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] answer = new char[n];
		
		for(int i=0; i<n; i++) {
			answer[i] = '0';

			int maxValue = 0;
			
			Map<Character, Integer> map = new HashMap<>();
			String str = br.readLine();
			
			for(char c : str.toCharArray()) {
				if(c == ' ') continue;
				
				map.put(c, map.getOrDefault(c, 0)+1);
				maxValue = Math.max(maxValue, map.get(c));
			}
			
			for(char key : map.keySet()) {
				int tmp = map.get(key);
				
				if(maxValue == tmp) {
					if(answer[i] == '0') {
						answer[i] = key;
					} else {
						answer[i] = '?';
					}
				}
			}
			
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(answer[i]);
		}
		
	}
}