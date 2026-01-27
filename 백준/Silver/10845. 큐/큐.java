
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("push")) {
				queue.offer(Integer.parseInt(st.nextToken()));
			} else if(str.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.poll() + "\n");
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
					sb.append(queue.peek() + "\n");
				}
			} else if(str.equals("back")) {
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					int size = queue.size();
					for(int j=0; j<queue.size(); j++) {
						int num = queue.poll();
						if(j == size-1) {
							sb.append(num + "\n");
						}
						queue.offer(num);
					}
				}
			}
		}
		
		System.out.print(sb.toString());
		
	}
}
