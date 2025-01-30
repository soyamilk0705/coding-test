import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            } else{
                int temp = stack.peek();
                if(temp != arr[i]){
                    stack.push(arr[i]);
                } 
            }
        }
        
        int[] answer = new int[stack.size()];
        
        for(int i=stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}