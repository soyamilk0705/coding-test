
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder answer = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		
		
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '<') {
				if(tmp.length() > 0) {
					answer.append(tmp.reverse().toString());
					tmp = new StringBuilder();
				}
				answer.append(c);
				i++;
				
				while(str.charAt(i) != '>') {
					answer.append(str.charAt(i));
					i++;
				}
				
				answer.append(">");
				
			} else if(c == ' ') {
				answer.append(tmp.reverse() + " ");
				tmp = new StringBuilder();
			} else {
				tmp.append(c);
			}
		}
		
		if(tmp.length() > 0) {
			answer.append(tmp.reverse());
		}
		
		System.out.println(answer);
	}
}

