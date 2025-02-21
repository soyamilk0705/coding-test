import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Long, Long> map = new HashMap<>();
	static long p;
	static long q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		
		map.put(0L, 1L);
		find(n);
		System.out.println(map.get(n));

	}
	
	static long find(long n) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		
		long first = find((long)Math.floor(n/p));
		long second = find((long)Math.floor(n/q));
		
		map.put(n, first+second);
		return first + second;
		
	}
	
}
