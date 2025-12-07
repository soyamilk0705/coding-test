
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char answer = ' ';
		Map<Character, Integer> map = new HashMap<>();

		int maxValue = 0;
		
		for(char c : str.toCharArray()) {
			char key = Character.toUpperCase(c);
			
			if(map.containsKey(key)) {
				map.replace(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}

			maxValue = Math.max(maxValue, map.get(key));
		}
		
		boolean flag = false;
		
		for(char key : map.keySet()) {
			if(maxValue == map.get(key)) {
				if(flag) {
					answer = '?';
					break;
				} else {
					answer = key;
					flag = true;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
