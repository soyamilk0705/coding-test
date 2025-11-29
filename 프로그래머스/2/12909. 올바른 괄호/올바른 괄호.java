import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == ')' && !stack.isEmpty()){
                stack.pop();
            } else{
                stack.push('(');
            }
        }
        
        if(stack.size() != 0){
            return false;
        }

        return true;
    }
}