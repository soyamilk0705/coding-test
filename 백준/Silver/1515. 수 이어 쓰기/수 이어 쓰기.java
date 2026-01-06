
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		
		int N = 1;
		int idx = 0;
		
		while(idx < target.length()) {
			String num = String.valueOf(N);
			
			for(int i=0; i<num.length(); i++) {
				if(idx < target.length() && num.charAt(i) == target.charAt(idx)) {
					idx++;
				}
			}
			
			N++;
			
		}

		System.out.println(N-1);
	}
}

