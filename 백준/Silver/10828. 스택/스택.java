
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(str.equals("pop")) {
				if(stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
			} else if(str.equals("size")) {
				sb.append(stack.size() + "\n");
			} else if(str.equals("empty")) {
				if(stack.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if(str.equals("top")) {
				if(stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
}

