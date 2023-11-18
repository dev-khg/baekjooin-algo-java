import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(')' == s.charAt(i)) {
                if(stack.isEmpty()) {
                    return  false;
                }                
                stack.pop();
            } else {
                stack.push('(');
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}