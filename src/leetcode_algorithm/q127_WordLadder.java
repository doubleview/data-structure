package leetcode_algorithm;

import java.util.*;

/**

Given two words (beginWord and endWordWord), and a wordListionary's word list, find the length of shortest transformation sequence from beginWord to endWordWord, such that:

        Only one letter can be changed at a time.
        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
        For example,

        Given:
        beginWord = "hit"
        endWordWord = "cog"
        wordList = ["hot","dot","dog","lot","log","cog"]
        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        return its length 5.

        Note:
        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.
        You may assume no duplicates in the word list.
        You may assume beginWord and endWordWord are non-empty and are not the same.

*/

public class q127_WordLadder {


    public static void main(String[] args) {
        q127_WordLadder solution = new q127_WordLadder();
        System.out.println(solution.ladderLength("hit" , "cog" , Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

    
    Map<String,List<String>> map;
    List<List<String>> results;

    /**
     * ½â·¨1
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<>();
        if(wordList.size() == 0) return 0;
        //wordList.add(endWord);

        int min = Integer.MAX_VALUE;
        map = new HashMap<>();

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        Map<String, Integer> ladder = new HashMap<>();
        for(String string : wordList) ladder.put(string, Integer.MAX_VALUE);
        ladder.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if(step > min)break;
            for(int i = 0;i<word.length();i++) {
                StringBuilder builder = new StringBuilder(word);
                for(char ch = 'a';ch<='z';ch++) {
                    builder.setCharAt(i , ch);
                    String new_word = builder.toString();
                    if (ladder.containsKey(new_word)) {
                        if(step > ladder.get(new_word)) continue;
                        else if (step < ladder.get(new_word)) {
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        }else;

                        if(map.containsKey(new_word))
                            map.get(new_word).add(word);
                        else {
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            map.put(new_word, list);
                        }
                        if(new_word.equals(endWord))
                            min = step;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min+1;
    }

}
