import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String pattern = br.readLine().replaceAll("\\*", "[a-z]*");
		
		Pattern p = Pattern.compile(pattern);
		
		for(int i=0; i<n; i++) {
			String value = br.readLine();

			Matcher m = p.matcher(value);
			
			if(m.matches()) {
				sb.append("DA\n");
			} else {
				sb.append("NE\n");
			}
		}
		
		System.out.println(sb.toString());
	
	}
}
