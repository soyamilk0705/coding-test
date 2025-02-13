import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		List<Recruitment[]> testCases = new ArrayList<>();
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			Recruitment[] recruit = new Recruitment[n];
			
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				recruit[j] = new Recruitment(document, interview);
			}
			
			testCases.add(recruit);
		}
		
		
		for(int i=0; i<t; i++) {
			Recruitment[] testCase = testCases.get(i);
			
			Arrays.sort(testCase, (o1, o2) ->{
				return o1.document - o2.document;
			});
			
			int winI = testCase[0].interview;
			int cnt = 1;
			
			for(int j=1; j<testCase.length; j++) {
				if(testCase[j].interview < winI) {
					cnt++;
					winI = testCase[j].interview;
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
	
}
