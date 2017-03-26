package leetcode_algorithm;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class q020_ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()[]{"));
    }

    /**
     * 解法1 (个人解法)
     * 利用栈
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Map<Character , Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Deque<Character> queue = new ArrayDeque<>();
        for(int i = 0; i< s.length();i++) {
            Character c = s.charAt(i);
            if (map.keySet().contains(c)) {
                queue.push(c);
            }else {
                Character temp = queue.poll();
                if(temp == null || map.get(temp) != c)
                    return false;
            }
        }
        return queue.isEmpty();
    }

}
