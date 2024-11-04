import java.util.*;

class Solution {
    private static List<Integer> result = new ArrayList<>();
    private static boolean[] visited;
    
    public int[] solution(int[] numbers) {
        visited = new boolean[numbers.length];
        add(numbers, 0);
        
        Collections.sort(result);
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
    
    public static void add(int[] numbers, int i){
        visited[i] = true;
        
        for(int k=i+1; k<numbers.length; k++){
            int sum = numbers[i] + numbers[k];
            
            if(!result.contains(sum)){
                result.add(sum);
            }
            
        }
        
        for(int j=0; j<visited.length; j++){
            if(!visited[j]){
                add(numbers, i+1);
            }
        }
    }
}