import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> sets = new HashMap<>();
        
        for(String phone : phone_book) {
            sets.put(phone, 1);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            int len = phone_book[i].length();
            for(int j = 0; j < len; j++) {
                if(sets.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}