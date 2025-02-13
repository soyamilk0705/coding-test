import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Recruitment{
		public int document;
		public int interview;
		
		public Recruitment(int document, int interview) {
			this.document = document;
			this.interview = interview;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			Recruitment[] recruit = new Recruitment[n];
			
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				recruit[j] = new Recruitment(document, interview);
			}
			
			Arrays.sort(recruit, (o1, o2) ->{
				return o1.document - o2.document;
			});
			
			int winI = recruit[0].interview;
			int cnt = 1;
			
			for(int j=1; j<recruit.length; j++) {
				if(recruit[j].interview < winI) {
					cnt++;
					winI = recruit[j].interview;
				}
			}
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
	
}
