
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder answer = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		
		Queue<Character> queue = new LinkedList<>();
		
		for(char c : str.toCharArray()) {
			queue.offer(c);
		}
		
		
		while(!queue.isEmpty()) {
			char c = queue.poll();
			
			if(c == '<') {
				if(tmp.length() > 0) {
					answer.append(tmp.reverse().toString());
					tmp = new StringBuilder();
				}
				answer.append("<");
				
				char t = queue.poll();
				while(t != '>') {
					answer.append(t);
					t = queue.poll();
				}
				
				answer.append(">");
				
			} else if(c == ' ') {
				answer.append(tmp.reverse().toString() + " ");
				tmp = new StringBuilder();
			} else {
				tmp.append(c);
			}
		}
		
		if(tmp.length() > 0) {
			answer.append(tmp.reverse().toString());
		}
		
		System.out.println(answer.toString());
	}
}

