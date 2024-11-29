import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int twoSafe = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left < right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
                twoSafe++;
            } else{
                right--;
            }
        }
        
        return people.length - twoSafe;
    }
}