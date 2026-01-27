
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new ArrayDeque<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) {
				queue.offerLast(Integer.parseInt(st.nextToken()));
			} else if(str.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.pollFirst() + "\n");
				}
			} else if(str.equals("size")) {
				sb.append(queue.size() + "\n");
			} else if(str.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append("1\n");	
				} else {
					sb.append("0\n");
				}
			} else if(str.equals("front")) {
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peekFirst() + "\n");
				}
			} else if(str.equals("back")) {
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peekLast() + "\n");
				}
			}
		}
		
		System.out.print(sb.toString());
		
	}
}

