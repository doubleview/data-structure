package leetcode_algorithm;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

public class q067_AddBinary {

    public static void main(String[] args) {
        System.out.println(new q067_AddBinary().addBinary("11", "11"));
    }

    /**
     *
     *  ½â·¨1
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
