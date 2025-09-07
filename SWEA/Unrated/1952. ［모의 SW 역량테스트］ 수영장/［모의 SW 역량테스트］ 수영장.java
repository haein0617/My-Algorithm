import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	private static int[] price;
	private static int[] swim;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테케 입력
		
		for (int tc = 1; tc <=t ; tc++) {//테케 시작
			price = new int[4]; //일,달,3달,년 가격
			swim = new int[15]; // 0제외, 1~12월 후 3개월 계산 때문에 뒤에 조금 더 늘려놓음.
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < 13; i++) {
				
				swim[i] = Integer.parseInt(st.nextToken());
			}
			
			
			result = Integer.MAX_VALUE;
			dfs(1,0);
			result = Math.min(result, price[3]);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
			
		}//테케 끝
		System.out.println(sb.toString());
	}

	private static void dfs(int month,int curCost) {
		if(month>12) {
			result = Math.min(curCost, result);
			return;
		}
		
		if(curCost >= result) {
			return;
		}
		if(swim[month] > 0) {
			
			dfs(month+1, curCost + swim[month]*price[0]); //1일권으로 구매
			dfs(month+1, curCost + price[1]); //1달 이용권 구매
			dfs(month+3, curCost + price[2]); //3달 이용권 구매
		}else {
			dfs(month+1,curCost);
		}
		
		
	}
}
