import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        
        
        return stack.isEmpty() ? true : false;
    }
}