package leetcode_algorithm;

/**
 *
 *
 * Implement atoi to convert a string to an integer.
 *
 *
 */

public class q008_StringToInteger {


    public static void main(String[] args) {
        System.out.println(myAtoi("-123467"));
        System.out.println(myAtoi("123467"));
        System.out.println(myAtoi(new Integer(Integer.MAX_VALUE).toString()));
        System.out.println(myAtoi(new Integer(Integer.MIN_VALUE).toString()));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("+5"));
        System.out.println(myAtoi("-5"));
        System.out.println(myAtoi("   010"));
        System.out.println(myAtoi("12a456"));
    }

    /**
     * 解法1(个人解法)
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        str = str.trim();
        long result = 0;
        int flag = 1;
        for(int i = 0 ;i < str.length() ;i++){
            if(i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+') && str.length()>1 ){
                flag = str.charAt(i) == '-' ? -1 : 1;
                continue;
            }
            if(!new String(new char[]{str.charAt(i)}).matches("0|1|2|3|4|5|6|7|8|9")){
                return (int)result*flag;
            }
            result = result*10 + str.charAt(i) - '0';
            if(result > Integer.MAX_VALUE)
                return  flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return  (int) result*flag;
    }

    /**
     * 解法2
     *
     * @param str
     * @return
     */
    public static int myAtoi2(String str) {
        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }

}
