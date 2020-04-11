package suanfa;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @author Mechrevo
 * @version v1.0
 * 2020/4/7 21:03
 */
public class Solution_4 {
    public static void main(String[] args) {
        int[] A = {1,3};
        int[] B = {2};
        System.out.println(findMedianSortedArrays(A, B));
    }

    /**
     * 双指针移动指针（m+n+1）/2 次得到两个数求平均值
     * 如果m+n为奇数 （m+n+1）/2 得到为同一个数
     * 如果m+n为偶数 （m+n+1）/2 得到为两个数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n == 0) {
            return (nums1[(m) / 2] + nums1[(m - 1) / 2]) / 2.0;
        }
        if (m == 0) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int leftM = 0, leftN = 0;
        int rightN = n - 1, rightM = m - 1;
        int leftRes = 0, rightRes = 0;

        int tmp = (m + n + 1) / 2;
        for (int i = 0; i < tmp; i++) {
            // 从小往大找 每次取最小的值，注意下标越界
            if ((leftN >= n) || (leftM<m && nums1[leftM] < nums2[leftN])) {
                leftRes = nums1[leftM];
                leftM++;
            } else {
                leftRes = nums2[leftN];
                leftN++;
            }

            // 从大往小找
            if ((rightN <0) || (rightM>=0 && rightM>=0 && nums1[rightM] > nums2[rightN])) {
                rightRes = nums1[rightM];
                rightM--;
            } else {
                rightRes = nums2[rightN];
                rightN--;
            }
        }
        return (rightRes + leftRes) / 2.0;

    }

    /**
     * 二分法，将每个数组分成两份，中位数在四份中的两个里
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        return 0.0;
    }
}
