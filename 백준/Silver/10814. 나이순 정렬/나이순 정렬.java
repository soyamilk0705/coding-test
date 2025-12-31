
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Member{
	int age;
	String name;
	
	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	
	}
}

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;

		List<Member> members = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members.add(new Member(age, name));
		}
		
	
		members.sort((a, b) -> Integer.compare(a.age, b.age));
		
		for(Member m : members) {
			System.out.println(m.age + " " + m.name);
		}
		
	}
}
