package leetcode_algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

        For example, given:
        s: "barfoothefoobarman"
        words: ["foo", "bar"]

        You should return the indices: [0,9].
        (order does not matter).

*/

public class q030_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        System.out.println(new q030_SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman",
                new String[]{"foo" , "bar"}));
        System.out.println(new q030_SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word","good","best","good"}));
    }

    /**
     *½â·¨1
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }
        for(int i = 0 ;i< s.length() - len*words.length +1; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for(int j = 0;j<words.length;j++) {
                String str = s.substring(i + j * len, i + j * len + len);
                if(copy.containsKey(str)){
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                }else  break;
            }
        }
        return res;
    }

}
