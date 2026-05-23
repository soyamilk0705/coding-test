import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        
        for(int l : lost){
            students[l]--;
        }
        
        for(int r : reserve){
            students[r]++;
        }
       
        for(int i=1; i<=n; i++){
            if(students[i] == 0){
                if(i > 1 && students[i-1] == 2){
                    students[i]++;
                    students[i-1]--;
                } else if(i < n && students[i+1] == 2){
                    students[i]++;
                    students[i+1]--;
                }
            }

        }
        
        for(int i=1; i<students.length; i++){
            if(students[i] >= 1){
                answer++;
            }
        }
        
        
    
        return answer;
    }
}