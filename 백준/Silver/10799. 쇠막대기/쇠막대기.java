import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split("");
		Stack<String> stack = new Stack<>();
		int result = 0;
		
		for(int i=0; i<inputs.length; i++) {
			if(inputs[i].equals("(")) {
				stack.push("(");
			} else {
				stack.pop();
				
				if(inputs[i-1].equals("(")) {
					result += stack.size(); 
				} else {
					result++;
				}
			}
		}
		
		System.out.println(result);
	
	}
}
