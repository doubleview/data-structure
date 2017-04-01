package leetcode_algorithm;


import java.util.*;


/**

Given an array of strings, group anagrams together.

        For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Return:

        [
        ["ate", "eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]

*/

public class q049_GroupAnagrams {


    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new q049_GroupAnagrams().groupAnagrams(strs));
    }


    /**
     * 解法1(推荐解法)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
