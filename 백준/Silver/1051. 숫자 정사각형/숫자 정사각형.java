import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] box;
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				box[i][j] = str.charAt(j) - '0';
			}
		}
		
		int len = Math.min(n, m);
		
		while(len > 1) {
			for(int i=0; i<=n-len; i++) {
				for(int j=0; j<=m-len; j++) {
					int num = box[i][j];
					
					if(num==box[i][j+len-1] && num == box[i+len-1][j] && num == box[i+len-1][j+len-1]) {
						System.out.println(len*len);
						return;
					}
				}
			}
			len--;
		}
		
		System.out.println(len*len);
		
	}
	
	
}
