import java.util.*;

class Solution {
    char[] oper = {'*', '+', '-'};
    boolean[] visited = new boolean[3];
    List<Long> numbers = new ArrayList<>();
    List<Character> operations = new ArrayList<>();
    
    char[] priority = new char[3];
    
    long answer = 0;
    
    
    public long solution(String expression) {
        String number = "";
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                number += c;
            } else{
                numbers.add(Long.parseLong(number));
                operations.add(c);
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
                priority[depth] = oper[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    
    public void calc(){
        List<Long> num = new ArrayList<>(numbers);
        List<Character> oper = new ArrayList<>(operations);
        
        for(char pri : priority){
            for(int i=0; i<oper.size(); i++){
                if(oper.get(i) != pri){
                    continue;
                }
                
                long n = 0;
                
                if(oper.get(i) == '*'){
                    n = num.get(i) * num.get(i+1);
                } else if(oper.get(i) == '+'){
                    n = num.get(i) + num.get(i+1);
                } else{
                    n = num.get(i) - num.get(i+1);
                }
                
                num.set(i, n);
                num.remove(i+1);
                oper.remove(i);
                
                i--;
            }
        }
        
        answer = Math.max(Math.abs(num.get(0)), answer);
    }
}