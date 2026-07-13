import java.util.*;

class Solution {
    char[] oper = {'*', '+', '-'};
    boolean[] visited = new boolean[3];
    List<Long> numbers = new ArrayList<>();
    List<Character> operations = new ArrayList<>();
    
    String cals = "";
    long answer = 0;
    
    public long solution(String expression) {
        String num = "";
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                num += c;
            } else{
                operations.add(c);
                numbers.add(Long.parseLong(num));
                num = "";
            }
        }
        
        numbers.add(Long.parseLong(num));
        
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int depth){
        if(depth == 3){
           calculate(cals);
        }
        
        for(int i=0; i<3; i++){
            if(!visited[i]){
                visited[i] = true;
                cals += oper[i];
                dfs(depth + 1);
                cals = cals.substring(0, cals.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    public void calculate(String oper){
        List<Long> num = new ArrayList<>(numbers);
        List<Character> op = new ArrayList<>(operations);
        
        for(char o : oper.toCharArray()){
            long value = 0;
            
            for(int i=0; i<op.size(); i++){
                if(op.get(i) == o){
                    if(o == '+'){
                        value = num.get(i) + num.get(i+1);
                    } else if(o == '-'){
                        value = num.get(i) - num.get(i+1);
                    } else {
                        value = num.get(i) * num.get(i+1);
                    }
                    
                    num.set(i, value);
                    num.remove(i+1);
                    
                    op.remove(i);
                    i--;
                    
                }
            }
        }
        
        answer = Math.max(answer, Math.abs(num.get(0)));
        
    }
}