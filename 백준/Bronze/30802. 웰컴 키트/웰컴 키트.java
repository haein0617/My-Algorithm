import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] size = new int[6];
		
		for(int i = 0;i<6;i++) {//각 사이즈 별 옷 수
			size[i]=sc.nextInt();
		}
		int t = sc.nextInt();
		int p = sc.nextInt();
		int sum=0;
		for(int i = 0;i<6;i++) {
			while(size[i]>0) {
				size[i]-=t; //사이즈에 한 묶음 씩 빼고
				sum++; // 몇 번 뺐는지 카운트
			}
		}
		System.out.println(sum);
		System.out.printf("%d %d",n/p,n%p);
		
	}
}
