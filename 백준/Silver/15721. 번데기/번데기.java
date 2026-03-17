
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static int a, t, guho;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Integer.parseInt(br.readLine());
		t = Integer.parseInt(br.readLine());
		guho = Integer.parseInt(br.readLine());
		
		System.out.print(play());
	}
	
	static int play() {
		int b = 0;
		int d = 0;
		int n = 2;
		
		while(true) {
			for(int i=0; i<4; i++) {
				if(i % 2 == 0) {
					b++;
					if(b == t && guho == 0) {
						return (b + d - 1) % a;
					}
				} else {
					d++;
					if(d == t && guho == 1) {
						return (b + d - 1) % a;
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				b++;
				if(b == t && guho == 0) {
					return (b + d - 1) % a;
				}
			}
			
			for(int i=0; i<n; i++) {
				d++;
				if (d == t && guho == 1) {
					return (b + d - 1) % a;
				}
			}
			
			n++;
		}
	}
}

