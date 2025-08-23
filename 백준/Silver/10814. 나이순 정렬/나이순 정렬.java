import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<person> members = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			members.add(new person(age,name));
		}
		Collections.sort(members);
		
		StringBuilder sb = new StringBuilder();
		for (person member : members) {
			sb.append(member.age).append(" ").append(member.name).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}

class person implements Comparable<person>{
	int age;
	String name;
	
	
	public person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int compareTo(person other) {
		return this.age-other.age;
	}
	
	
}
