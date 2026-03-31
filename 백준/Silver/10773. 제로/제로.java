
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp == 0) {
				stack.pop();
			} else {
				stack.push(tmp);
			}
		}
		
		
		int answer = 0;
		while(!stack.isEmpty()) {
			answer += stack.pop();
		
		}
		
		System.out.println(answer);
	}
	
	
}

