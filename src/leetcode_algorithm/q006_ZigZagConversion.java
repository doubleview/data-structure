package leetcode_algorithm;
/**

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)


        P   A   H   N
        A P L S I I G
        Y   I   R

        And then read line by line: "PAHNAPLSIIGYIR"

*/

/**
     n=numRows
 Δ=2n-2    1                           2n-1                         4n-3
 Δ=        2                     2n-2  2n                    4n-4   4n-2
 Δ=        3               2n-3        2n+1              4n-5       .
 Δ=        .           .               .               .            .
 Δ=        .       n+2                 .           3n               .
 Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
 Δ=2n-2    n                           3n-2                         5n-4

*/
public class q006_ZigZagConversion {


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING" , 3));
        System.out.println(convert2("PAYPALISHIRING" , 3));
    }


    /**
     * 解法1(个人解法)
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < numRows;i++) {
            sb.append(s.charAt(i));

            int index = 2*numRows -1;
            while (index - 1 - i< s.length()){
                if(i != numRows -1 ){
                    sb.append(s.charAt(index - 1 - i));
                }

                if(index - 1 + i < s.length() && i != 0){
                    sb.append(s.charAt(index -1 + i));
                }
                index = index + 2*numRows - 2;
            }
        }
        return  sb.toString();
    }

    /**
     * 解法2
     *
     * @param s
     * @param nRows
     * @return
     */
    public static String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

}
