import java.util.*;

class Solution {
    public int solution(String[][] clothes) {        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] clothe : clothes) {
            int count = map.getOrDefault(clothe[1], 0);
            map.put(clothe[1], count + 1);
        }
        
        if(map.size() == 1) {
            String[] cl = clothes[0];
            return map.get(cl[1]);
        } else {
            int an = 1;
            for(String key : map.keySet()) {
                an *= (map.get(key) + 1);
            }
            return an - 1;
        }
        
    }
}