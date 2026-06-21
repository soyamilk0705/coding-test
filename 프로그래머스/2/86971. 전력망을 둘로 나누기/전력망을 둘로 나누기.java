import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++){
            List<List<Integer>> nodes = new ArrayList<>();
            int cnt = 1;
            boolean[] visited = new boolean[n+1];
            
            for(int j=0; j<=n; j++){
                nodes.add(new ArrayList<>());
            }
            
            for(int j=0; j<wires.length; j++){
                if(i == j) continue;
                
                int a = wires[j][0];
                int b = wires[j][1];
                
                nodes.get(a).add(b);
                nodes.get(b).add(a);
            }
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            visited[1] = true;
            
            while(!queue.isEmpty()){
                int now = queue.poll();
                
                for(int node : nodes.get(now)){
                    if(!visited[node]){
                        visited[node] = true;
                        queue.offer(node);
                        cnt++;
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        return answer;
    }
}