
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String file = br.readLine();
			String op = file.substring(file.indexOf(".")+1);
			map.put(op, map.getOrDefault(op, 0)+1);
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		
		Collections.sort(keySet);
		
		for(String key : keySet) {
			System.out.println(key + " " + map.get(key));
		}
	}
}
