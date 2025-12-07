
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<List<Character>> list = new ArrayList<>();
		
		int maxLen = 0;
		
		for(int i=0; i<5; i++) {
			List<Character> tmp = new ArrayList<>();
			String str = br.readLine();
			
			for(int j=0; j<str.length(); j++) {
				tmp.add(str.charAt(j));
			}
			maxLen = Math.max(maxLen, tmp.size());
			list.add(tmp);
		}
		
		for(int i=0; i<maxLen; i++) {
			for(int j=0; j<5; j++) {
				if(list.get(j).size() <= i) {
					continue;
				}
				
				sb.append(list.get(j).get(i));
			}
		}
		
		System.out.println(sb.toString());
		
	}
}