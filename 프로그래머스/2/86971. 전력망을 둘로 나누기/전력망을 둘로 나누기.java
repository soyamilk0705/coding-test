import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++){
            List<List<Integer>> tops = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            
            for(int j=0; j<=n; j++){
                tops.add(new ArrayList<>());
            }
            
            for(int j=0; j<wires.length; j++){
                if(i==j) continue;
                
                int a = wires[j][0];
                int b = wires[j][1];
                
                tops.get(a).add(b);
                tops.get(b).add(a);
            }
            
            queue.offer(1);
            visited[1] = true;
            int cnt = 1;
                
            while(!queue.isEmpty()){
                int now = queue.poll();
                
                for(int next : tops.get(now)){
                    if(!visited[next]){
                        queue.offer(next);
                        cnt++;
                        visited[next] = true;
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
        }
        
        
        
        return answer;
    }
}