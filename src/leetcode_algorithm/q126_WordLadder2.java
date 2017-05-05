package leetcode_algorithm;

import java.util.*;

/**

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

        Only one letter can be changed at a time
        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
        For example,

        Given:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log","cog"]
        Return
        [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
        ]

*/

public class q126_WordLadder2 {


    public static void main(String[] args) {
        q126_WordLadder2 solution = new q126_WordLadder2();
        System.out.println(solution.findLadders("hit" , "cog" , Arrays.asList("hot","dot","dog","lot","log","cog")));

    }


    Map<String,List<String>> map;
    List<List<String>> results;

/**
    The solution contains two steps 1 Use BFS to construct a graph. 2. Use DFS to construct the paths from end to start.Both solutions got AC within 1s.

    The first step BFS is quite important. I summarized three tricks

    Using a MAP to store the min ladder of each word, or use a SET to store the words visited in current ladder, when the current ladder was completed, delete the visited words from unvisited. That's why I have two similar solutions.
    Use Character iteration to find all possible paths. Do not compare one word to all the other words and check if they only differ by one character.
    One word is allowed to be inserted into the queue only ONCE. See my comments.

    */
    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        results = new ArrayList<>();
        if(dict.size() == 0) return results;
        //dict.add(end);

        int min = Integer.MAX_VALUE;
        map = new HashMap<>();

        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);

        Map<String, Integer> ladder = new HashMap<>();
        for(String string : dict) ladder.put(string, Integer.MAX_VALUE);
        ladder.put(start, 0);

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
                        if(new_word.equals(end))
                            min = step;
                    }
                }
            }
        }
        LinkedList<String> result = new LinkedList<>();
        backTrace(end , start , result);
        return results;
    }

    private void backTrace(String word, String start, List<String> list) {
        if(word.equals(start)){
            list.add(0, start);
            results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for(String s : map.get(word))
                backTrace(s , start , list);
        list.remove(0);
    }
}
