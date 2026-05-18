import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> airs = new ArrayList<>();
    static boolean finish = false;
    
    public void dfs(int cnt, String start, String[][] tickets){
        if(cnt == tickets.length){
            finish = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                airs.add(tickets[i][1]);
                
                dfs(cnt+1, tickets[i][1], tickets);
                
                if(finish){
                    return;
                }
                
                visited[i] = false;
                airs.remove(airs.size() - 1);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        airs.add("ICN");
        dfs(0, "ICN", tickets);
        
        return airs.toArray(new String[airs.size()]);
    }
}