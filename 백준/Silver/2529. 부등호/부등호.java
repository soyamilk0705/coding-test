import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static boolean[] visited = new boolean[10];
	static List<String> answer = new ArrayList<>();
	static char[] signs;
	static int k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		signs = new char[k];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<k; i++) {
			signs[i] = st.nextToken().charAt(0);
		}
		
		for(int i=0; i<10; i++) {
			visited[i] = true;
			dfs(i, 0, i+"");
			visited[i] = false;
		}
		
		System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));
		
	}
	
	static void dfs(int start, int cnt, String word) {
		if(word.length() == k+1) {
			answer.add(word);
			return;
		}
		
		
		for(int i=0; i<10; i++) {
			if(!visited[i]) {
				char sign = signs[cnt];
				
				if(sign == '<') {
					if(start < i) {
						visited[i] = true;
						dfs(i, cnt+1, word+i);
						visited[i] = false;
					}
				} else {
					if(start > i) {
						visited[i] = true;
						dfs(i, cnt+1, word+i);
						visited[i] = false;
					}
				}
			}
		}
	}
}
