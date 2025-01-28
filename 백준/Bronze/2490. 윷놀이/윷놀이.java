import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			
			for(int j=0; j<4; j++) {
				if(st.nextToken().equals("0")) {
					cnt++;
				}
			}
			
			switch(cnt) {
				case 0: sb.append("E"); break;
				case 1: sb.append("A"); break;
				case 2: sb.append("B"); break;
				case 3: sb.append("C"); break;
				case 4: sb.append("D"); break;
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
	
}
