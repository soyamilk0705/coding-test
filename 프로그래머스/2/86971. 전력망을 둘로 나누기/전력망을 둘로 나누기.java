import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int cut=0; cut<wires.length; cut++){
            List<List<Integer>> graph = new ArrayList<>();
            
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            
            for(int i=0; i<wires.length; i++){
                if(i == cut) continue;
                
                int a = wires[i][0];
                int b = wires[i][1];
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            // BFS
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new LinkedList<>();
            
            queue.offer(1);
            visited[1] = true;
            
            int count = 1;
            
            while(!queue.isEmpty()){
                int now = queue.poll();
                
                for(int next : graph.get(now)){
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                        count++;
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs(count - (n - count)));
        }
        
        
        return answer;
    }
}