
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int[] count = new int[26];
			String str = br.readLine();
			
			for(char c : str.toCharArray()) {
				if (c == ' ') continue;
				count[c - 'a']++;
			}
			
			int max = 0;
			for(int v : count) {
				max = Math.max(max, v);
			}
			
			int maxCount = 0;
			char result = '?';
			
			for(int j=0; j<26; j++) {
				if(count[j] == max) {
					maxCount++;
					result = (char) ('a' + j);
				}
			}
			
			if(maxCount > 1) result = '?';
			System.out.println(result);
		}
		
	}
}