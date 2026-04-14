
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int[] inputs = new int[n];
		
		int num = 1;
		
		for(int i = 0; i < n; i++) {
		    inputs[i] = Integer.parseInt(br.readLine());
		}

		
		for(int i=0; i<n; i++) {
			int target = inputs[i];
			
			while(num <= target) {
				stack.push(num++);
				sb.append("+\n");
			}
			
			if(!stack.isEmpty() && stack.peek() == target) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
	}
	
}
