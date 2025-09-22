import java.util.*;

class Solution {
    List<String> resultPath; // 최종 경로 저장 리스트
    boolean[] visited; // 방문 처리
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        resultPath = new ArrayList<>();
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (a, b) -> {
    // 먼저 출발지(a[0], b[0])를 비교해서 다르면, 출발지 순으로 정렬
    if (!a[0].equals(b[0])) {
        return a[0].compareTo(b[0]);
    }
    // 출발지가 같다면, 도착지(a[1], b[1]) 순으로 정렬
    else {
        return a[1].compareTo(b[1]);
    }
});
        
        dfs("ICN", "ICN", tickets);
        answer = new String[resultPath.size()];
        for(int i = 0; i < resultPath.size(); i++){
            answer[i] = resultPath.get(i);
        }
        return answer;
    }
    
     private void dfs(String currentAirport, String currentPath, String[][] tickets) {
        //모든 항공권을 사용했다면, 최종 경로를 찾은 것이므로 저장하고 종료
        String[] pathArray = currentPath.split(",");
        if (pathArray.length == tickets.length + 1) {
            // String 배열을 List에 한 번에 추가
            resultPath.addAll(Arrays.asList(pathArray));
            return;
        }

        //  현재 공항에서 출발하는 항공권 찾기
        for (int i = 0; i < tickets.length; i++) {
            // 아직 사용하지 않은 항공권이고, 출발지가 현재 공항과 같다면
            if (!visited[i] && tickets[i][0].equals(currentAirport)) {
                
                // 이미 최종 경로를 찾았다면 더 이상 탐색할 필요 없음
                if (!resultPath.isEmpty()) return;

                visited[i] = true; // 항공권 사용 처리 (방문)
                
                // 다음 공항으로 재귀 호출
                dfs(tickets[i][1], currentPath + "," + tickets[i][1], tickets);
                
                // 백트래킹: 위에서 갔던 경로가 막다른 길이었다면,
                // 항공권 사용을 취소하고 다른 경로를 탐색하기 위해 돌아감
                visited[i] = false;
            }
        }
    }
}