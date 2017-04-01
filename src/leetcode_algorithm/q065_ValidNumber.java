package leetcode_algorithm;

/**
 * Validate if a given string is numeric.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */

public class q065_ValidNumber {

    public static void main(String[] args) {
        System.out.println(new q065_ValidNumber().isNumber("0"));
        System.out.println(new q065_ValidNumber().isNumber("0.1"));
        System.out.println(new q065_ValidNumber().isNumber("abc"));
        System.out.println(new q065_ValidNumber().isNumber("1 a"));
        System.out.println(new q065_ValidNumber().isNumber("2e10"));
    }

    /**
     * 解法1(推荐解法)
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) return false;
                numberSeen = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        return numberSeen;
    }
}
