
import java.io.*;
import java.util.*;

public class Main {
	static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	static boolean isAcceptable(String s) {
		boolean hasVowel = false;
		int vowelCnt = 0;
		int consCnt = 0;
		
		for(int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			boolean vowel = isVowel(cur);
			
			if(vowel) {
				hasVowel = true;
				vowelCnt++;
				consCnt = 0;
			} else {
				consCnt++;
				vowelCnt = 0;
			}
			
			if(vowelCnt == 3 || consCnt == 3) {
				return false;
			}
			
			if(i > 0 && cur == s.charAt(i-1)) {
				if(cur != 'e' && cur != 'o') {
					return false;
				}
			}
		}
		
		return hasVowel;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		
		
		while(true) {

			String s = br.readLine();
			
			if(s.equals("end")) {
				break;
			}
			
			if(isAcceptable(s)) {
				System.out.println("<" + s + "> is acceptable.");
			} else {
				System.out.println("<" + s + "> is not acceptable.");
			}
		}
	}
}
