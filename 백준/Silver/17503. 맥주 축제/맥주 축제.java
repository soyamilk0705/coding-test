import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
	static class Beer{
		int favor;
		int level;
		
		public Beer(int favor, int level) {
			this.favor = favor;
			this.level = level;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Beer[] beers = new Beer[k];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int favor = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			beers[i] = new Beer(favor, level);
		}
		
	
		Arrays.sort(beers, Comparator.comparingInt(b -> b.level));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int favorSum = 0;
		int minLevel = -1;
		
		for(Beer beer : beers) {
			pq.add(beer.favor);
			favorSum += beer.favor;
			
			if(pq.size() > n) {
				favorSum -= pq.poll();
			}
			
			if(pq.size() == n && favorSum >= m) {
				minLevel = beer.level;
				break;
			}
		}
		
		
		System.out.println(minLevel);
	}
	
}
