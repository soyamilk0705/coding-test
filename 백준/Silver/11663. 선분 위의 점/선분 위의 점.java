import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] points;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		points = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(points);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(end) - lowerBound(start)).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	public static int upperBound(int key) {
		int left = 0;
		int right = N;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(key < points[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	public static int lowerBound(int key) {
		int left = 0;
		int right = N;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(key <= points[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}