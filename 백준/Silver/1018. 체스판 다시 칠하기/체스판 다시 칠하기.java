import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] lines = new String[n];
		
		for(int i=0; i<n; i++) {
			lines[i] = br.readLine();
		}
		
		int sol = Integer.MAX_VALUE;


		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				int curSol = solved(i, j, lines);
				
				if(sol > curSol) {
					sol = curSol;
				}
				
			}
		}
		
		System.out.println(sol);
		
		
	}
	
	static int solved(int x, int y, String[] lines) {
		String[] board = {"WBWBWBWB", "BWBWBWBW"};
		int cnt = 0;
		
		for(int i=0; i<8; i++) {
			int startX = x + i;
			
			for(int j=0; j<8; j++) {
				int startY = y + j;
				
				if(lines[startX].charAt(startY) != board[startX % 2].charAt(j)) {
					cnt++;
				}
			}
		}
		
		return Math.min(cnt, 64-cnt);
	}
	
}