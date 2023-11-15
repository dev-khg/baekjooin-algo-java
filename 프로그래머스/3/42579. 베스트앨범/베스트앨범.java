import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreList = new ArrayList<>();        
        
        for(String key : genreMap.keySet()) {
            genreList.add(key);
        }
        
        genreList.sort((a, b) -> genreMap.get(b) - genreMap.get(a));
        
        for(String genre : genreList) {
            List<Music> musics = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genre.equals(genres[i])) {
                    musics.add(new Music(plays[i], i));
                }
            }
            
            musics.sort((a, b) -> {
                if(a.play == b.play) {
                    return a.idx - b.idx;
                }
                return b.play - a.play;
            });
            
            
            answer.add(musics.get(0).idx);
            if(musics.size() != 1) {
                answer.add(musics.get(1).idx);
            }
            
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    static class Music {
        int play;
        int idx;
        
        public Music(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
    }
}