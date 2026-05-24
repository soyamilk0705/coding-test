import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phones = new HashSet<>(List.of(phone_book));
        
        for(String phone : phones){
            for(int i=1; i<phone.length(); i++){
                String prefix = phone.substring(0, i);
                
                if(phones.contains(prefix)){
                    return false;
                }
            }
        }
        
        
        
        return answer;
    }
}