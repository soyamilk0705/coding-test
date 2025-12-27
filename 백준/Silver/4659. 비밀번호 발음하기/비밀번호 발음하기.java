import java.io.*;
import java.util.*;

public class Main {
	static List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u');
	
	static boolean checkVowel(String str) {
		for(char v : vowel) {
			if(str.contains(String.valueOf(v))) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean checkTwo(String str) {
		for(int i=1; i<str.length(); i++) {
			char c1 = str.charAt(i-1);
			char c2 = str.charAt(i);
			
			if(c1 == c2) {
				if(c1 != 'e' && c1 != 'o') {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean checkThree(String str) {
		if(str.length() < 3) {
			return true;
		}
		
		for(int i=0; i<str.length()-2; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(i+1);
			char c3 = str.charAt(i+2);
			
			if(vowel.contains(c1) && vowel.contains(c2) && vowel.contains(c3)) {
				return false;
			}
			
			if(!vowel.contains(c1) && !vowel.contains(c2) && !vowel.contains(c3)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		
		String s = br.readLine();
		
		while(!s.equals("end")) {
			list.add(s);
			s = br.readLine();
		}
		
		for(String str : list) {
			if(!checkVowel(str)) {
				System.out.println("<" + str + "> is not acceptable.");
				continue;
			} else if(!checkThree(str)) {
				System.out.println("<" + str + "> is not acceptable.");
				continue;
			} else if(!checkTwo(str)) {
				System.out.println("<" + str + "> is not acceptable.");
				continue;
			} else {
				System.out.println("<" + str + "> is acceptable.");
			}
			
		}
	
	}
}