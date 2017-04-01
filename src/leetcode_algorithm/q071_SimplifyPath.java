package leetcode_algorithm;

import java.util.*;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */

public class q071_SimplifyPath {

    public static void main(String[] args) {
        System.out.println(new q071_SimplifyPath().simifyPath("../"));
        System.out.println(new q071_SimplifyPath().simifyPath("/home/"));
        System.out.println(new q071_SimplifyPath().simifyPath("/a/./b/../../c/"));
    }

    /**
     * 解法1(推荐解法)
     *
     * @param path
     * @return
     */
    public String simifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}
