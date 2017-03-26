package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

public class q093_RestoreIPAddresses {

    public static void main(String[] args) {
        q093_RestoreIPAddresses solution = new q093_RestoreIPAddresses();
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses2("000255"));
    }

    /**
     * 解法1 DFS
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<>();
        restoreIP(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIP(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);
        for (int i = 1; i < 4; i++) {
            if (idx + i > ip.length()) break;
            String s = ip.substring(idx, idx + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) > 255)) continue;
            restoreIP(ip, solutions, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }

    /**
     * 解法2
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    //判断ip是否合法
    public boolean isValid(String s) {
        if ((s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255))
            return false;
        return true;
    }

}