
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			queue.offer(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			int num = queue.poll();
			queue.offer(num);
		}
		
		System.out.println(queue.poll());
	}
}
