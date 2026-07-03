import java.util.*;

class Solution {
    char[] ex = {'*', '-', '+'};
    char[] priority = new char[3];
    boolean[] visited = new boolean[3];
    long answer = 0;
    
    List<Long> numbers = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    
    public long solution(String expression) {
        char[] arr = expression.toCharArray();
        
        
        String number = "";
        
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                number += c;
            } else {
                numbers.add(Long.parseLong(number));
                operators.add(c);
                number = "";
            }
        }
        numbers.add(Long.parseLong(number));
        
        dfs(0);
        return answer;
    }
    
    public void dfs(int depth){
        if(depth == 3){
            calc();
            return;
        }
        
        for(int i=0; i<3; i++){
            if(!visited[i]){
                visited[i] = true;
                priority[depth] = ex[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    
    public void calc(){
        List<Long> nums = new ArrayList<>(numbers);
        List<Character> ops = new ArrayList<>(operators);
        
        for(char op : priority){
            for(int i=0; i<ops.size(); i++){
                if(ops.get(i) != op){
                    continue;
                }
                
                long a = nums.get(i);
                long b = nums.get(i+1);
                
                long result = 0;
                
                if(op == '+'){
                    result = a + b;
                } else if(op == '-'){
                    result = a - b;
                } else {
                    result = a * b;
                }
                
                nums.set(i, result);
                nums.remove(i+1);
                ops.remove(i);
                
                i--;
            }
        }
        
        answer = Math.max(answer, Math.abs(nums.get(0)));
    }
}