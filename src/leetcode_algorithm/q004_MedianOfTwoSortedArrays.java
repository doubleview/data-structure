package leetcode_algorithm;


/**
     There are two sorted arrays nums1 and nums2 of size m and n respectively.

     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

     Example 1:
     nums1 = [1, 3]
     nums2 = [2]

     The median is 2.0

     Example 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

     The median is (2 + 3)/2 = 2.5
*/

public class q004_MedianOfTwoSortedArrays {


    public static void main(String[] args) {
        int[] m = new int[]{1  ,3};
        int[] n = new int[]{2};
        System.out.println(findMedianSortedArrays(m , n));
        System.out.println(findMedianSortedArrays2(m , n));

        m = new int[]{1 ,2};
        n = new int[]{3 , 4};
        System.out.println(findMedianSortedArrays(m , n));
        System.out.println(findMedianSortedArrays2(m , n));

        m = new int[]{};
        n = new int[]{3 , 4};
        System.out.println(findMedianSortedArrays(m , n));
        System.out.println(findMedianSortedArrays2(m , n));

        m = new int[]{1 ,1};
        n = new int[]{1 , 2};
        System.out.println(findMedianSortedArrays(m , n));
        System.out.println(findMedianSortedArrays2(m , n));

        m = new int[]{1 ,1 , 1 , 1 , 1};
        n = new int[]{1 , 2};
        System.out.println(findMedianSortedArrays(m , n));
        System.out.println(findMedianSortedArrays2(m , n));

        m = new int[]{3};
        n = new int[]{1 , 2};
        System.out.println(findMedianSortedArrays(m , n));
        System.out.println(findMedianSortedArrays2(m , n));
    }


    /**
     * 解法1(个人解法)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mposition = (nums1.length + nums2.length)/2;
        int max1 = -1;
        int max2 = -1;
        int m = -1;
        int n = -1;
        while(m < nums1.length && n < nums2.length && m+n +1 != mposition){
            if(m + 1 == nums1.length){
                n++;
                max2 = max1;
                max1 = nums2[n];
            }else if(n + 1== nums2.length){
                m++;
                max2 = max1;
                max1 = nums1[m];
            }else if(nums1[m+1] < nums2[n+1]){
                m++;
                if(nums1[m] > max1){
                    max2 = max1;
                    max1 = nums1[m];
                }else {
                    max2 = Math.max(max2 , nums1[m]);
                }
            }else {
                n++;
                if(nums2[n] > max1){
                    max2 = max1;
                    max1 = nums2[n];
                }else {
                    max2 = Math.max(max2 , nums2[n]);
                }
            }
        }
        if((nums1.length + nums2.length)%2 != 0){
            return  max1;
        }else {
            return ((double)max1 + (double)max2)/2;
        }
    }


    /**
     * 解法2
     *
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
}
