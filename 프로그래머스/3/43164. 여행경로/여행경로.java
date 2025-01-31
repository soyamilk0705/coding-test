import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    
    static void dfs(String[][] tickets, String start, String path, int cnt){
        if(cnt == tickets.length){
            answer.add(path);
            return;
        }
            
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}