import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        int pre = -1;
        for(int i = 0; i < arr.length; i++) {
            if(pre != arr[i]) {
                pre = arr[i];
                list.add(arr[i]);
            }
        }        
        
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}