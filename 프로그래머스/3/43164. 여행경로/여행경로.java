import java.util.*;

class Solution {
    static boolean[] visited;
    static boolean finish = false;
    List<String> answer = new ArrayList<>();
    
    public void dfs(int cnt, String start, String[][] tickets){
        if(cnt == visited.length){
            finish = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                answer.add(tickets[i][1]);
                dfs(cnt+1, tickets[i][1], tickets);
                
                if(finish){
                    return;
                }
                
                visited[i] = false;
                answer.remove(answer.size() - 1);
                dfs(cnt+1, tickets[i][1], tickets);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer.add("ICN");
        
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs(0, "ICN", tickets);
        
        return answer.toArray(new String[answer.size()]);
    }
}