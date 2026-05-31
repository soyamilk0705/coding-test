class Solution {
    public int solution(String name) {
        int answer = 0;
        int cnt = name.length();
        
        for(int i=0; i<name.length(); i++){
            answer += Math.min(
            'Z' - name.charAt(i) + 1,
            name.charAt(i) - 'A');
            
            int idx = i + 1;
            while(idx < name.length() && name.charAt(idx) == 'A'){
                idx++;
            }
            
            cnt = Math.min(cnt, i * 2 + name.length() - idx);
            cnt = Math.min(cnt, (name.length() - idx) * 2 + i);
        }
        
        return answer + cnt;
    }
}