class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        for (int num : nums1) {
            if (num == 0) zero1++;
            else sum1 += num;
        }

        for (int num : nums2) {
            if (num == 0) zero2++;
            else sum2 += num;
        }

        // Edge case: one array is all zeros and the other is not, but zero count is 0 on that side
        if ((zero1 == 0 && sum1 > sum2 + zero2) || (zero2 == 0 && sum2 > sum1 + zero1)) {
            return -1;
        }

        long minPossibleSum1 = sum1 + zero1 * 1;
        long minPossibleSum2 = sum2 + zero2 * 1;

        // Try to equalize both arrays by increasing the smaller one as little as possible
        if (minPossibleSum1 == minPossibleSum2) {
            return minPossibleSum1;
        } else if (minPossibleSum1 > minPossibleSum2) {
            long diff = minPossibleSum1 - minPossibleSum2;
            // Can we increase nums2 by diff using zero2?
            if (diff <= 9L * zero2) {
                return minPossibleSum1;
            } else {
                return -1;
            }
        } else {
            long diff = minPossibleSum2 - minPossibleSum1;
            // Can we increase nums1 by diff using zero1?
            if (diff <= 9L * zero1) {
                return minPossibleSum2;
            } else {
                return -1;
            }
        }
    }
}
