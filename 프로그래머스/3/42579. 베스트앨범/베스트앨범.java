import java.util.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<Integer>> musicMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }
        
        List<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
    
        
        for(String genre : genreList){
            List<Integer> musics = musicMap.get(genre);
            
            musics.sort((a, b) -> {
               if(plays[a] == plays[b]){
                   return a - b;
               }
                return plays[b] - plays[a];
            });
            
            for(int i=0; i<Math.min(2, musics.size()); i++){
                answer.add(musics.get(i));
            }
        }
        
        
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}