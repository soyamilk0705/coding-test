
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		List<Integer> answer = new ArrayList<>();
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		int not1 = -1;
		int not2 = -1;
		
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(arr[i] + arr[j] == sum - 100) {
					not1 = i;
					not2 = j;
					break;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i == not1 || i == not2) {
				continue;
			}
			System.out.println(arr[i]);
		}
		
		
	}
}

