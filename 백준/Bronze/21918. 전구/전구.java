
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] lights = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				lights[b] = c;
			} else if(a == 2) {
				for(int j=b; j<=c; j++) {
					if(lights[j] == 1) {
						lights[j] = 0;
					} else {
						lights[j] = 1;
					}
				}
			} else if(a == 3) {
				for(int j=b; j<=c; j++) {
					lights[j] = 0;
				}
			} else {
				for(int j=b; j<=c; j++) {
					lights[j] = 1;
				}
			}
		}
	
		for(int i=1; i<=n; i++) {
			System.out.print(lights[i] + " ");
		}
	}
}

