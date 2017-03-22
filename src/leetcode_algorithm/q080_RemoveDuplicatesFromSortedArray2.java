package leetcode_algorithm;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */

public class q080_RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {
        q080_RemoveDuplicatesFromSortedArray2 solution = new q080_RemoveDuplicatesFromSortedArray2();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    /**
     * ½â·¨1
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }
        return i;
    }


}
