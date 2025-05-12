import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int d1 = digits[i], d2 = digits[j], d3 = digits[k];

                    if (d1 == 0) continue;         // No leading zero
                    if (d3 % 2 != 0) continue;     // Must be even

                    int num = d1 * 100 + d2 * 10 + d3;
                    result.add(num);
                }
            }
        }

        // Convert to sorted array
        List<Integer> sorted = new ArrayList<>(result);
        Collections.sort(sorted);
        
        // Convert List<Integer> to int[]
        int[] ans = new int[sorted.size()];
        for (int i = 0; i < sorted.size(); i++) {
            ans[i] = sorted.get(i);
        }

        return ans;
    }
}
