
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int money = 0;
	static int[] machineDuck;
	
	static int Jun() {
		int balance = money;
		int cnt = 0;
		
		for(int i=1; i<=14; i++) {
			if(machineDuck[i] <= balance) {
				int buyCnt = balance / machineDuck[i];
				balance -= (machineDuck[i] * buyCnt);
				cnt += buyCnt;
			}
		}
		
		return balance + (machineDuck[14] * cnt);
	}
	
	static int Sung() {
		int balance = money;
		int cnt = 0;
		
		for(int i=1; i<=11; i++) {
			int first = machineDuck[i];
			int second = machineDuck[i+1];
			int third = machineDuck[i+2];
			
			if(first < second && second < third) {
				if (cnt != 0) {
					balance += machineDuck[i+3] * cnt;
					cnt = 0;
					
				}
			} else if(first > second && second > third) {
				if(machineDuck[i+3] <= balance) {
					int buyCnt = balance / machineDuck[i+3];
					balance -= (machineDuck[i+3] * buyCnt);
					cnt += buyCnt;
				}
			}
			
		}
		
		return balance + (machineDuck[14] * cnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		money = Integer.parseInt(br.readLine());
		machineDuck = new int[15];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=14; i++) {
			machineDuck[i] = Integer.parseInt(st.nextToken());
		}
		
		int junMoney = Jun();
		int sungMoney = Sung();
		
		if(junMoney == sungMoney) {
			System.out.println("SAMESAME");
		} else if(junMoney < sungMoney) {
			System.out.println("TIMING");
		} else {
			System.out.println("BNP");
		}
	}
}