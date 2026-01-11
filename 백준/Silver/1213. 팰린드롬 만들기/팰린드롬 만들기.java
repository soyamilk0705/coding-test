
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		int[] count = new int[26];
		
		for(char c : name.toCharArray()) {
			count[c - 'A']++;
		}
		
		int oddCount = 0;
		int oddIndex = -1;
		
		for(int i=0; i<26; i++) {
			if(count[i] % 2 == 1) {
				oddCount++;
				oddIndex = i;
			}
		}
		
		if(oddCount > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		StringBuilder left = new StringBuilder();
		
		for(int i=0; i<26; i++) {
			int repeat = count[i] / 2;
			for(int j=0; j<repeat; j++) {
				left.append((char) ('A' + i));
			}
		}
		
		String middle = "";
		if(oddIndex != -1) {
			middle = String.valueOf((char) ('A' + oddIndex));
		}
		
		String right = left.reverse().toString();
		
		left.reverse();
		
		System.out.println(left.toString() + middle + right);
	}
}
