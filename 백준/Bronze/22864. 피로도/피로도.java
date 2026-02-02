
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int hp = 0;
		int work = 0;
		int totalHour = 0;
		
		while(totalHour < 24) {
			if(hp + a <= m) {
				hp += a;
				work += b;
				totalHour += 1;
			} else {
				if(hp - c <= 0) {
					hp = 0;
				} else {
					hp -= c;
				}
				totalHour += 1;
			}
		}
		
		
		System.out.println(work);
	}
}

