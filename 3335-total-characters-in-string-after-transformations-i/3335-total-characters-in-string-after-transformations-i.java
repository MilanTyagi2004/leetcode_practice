class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;

        long[] counts = new long[26];

        // Initial character frequencies
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        // Perform t transformations
        for (int i = 0; i < t; i++) {
            long[] nextCounts = new long[26];

            for (int j = 0; j < 26; j++) {
                long cnt = counts[j];
                if (cnt == 0) continue;

                if (j == 25) { // 'z'
                    nextCounts[0] = (nextCounts[0] + cnt) % MOD; // 'a'
                    nextCounts[1] = (nextCounts[1] + cnt) % MOD; // 'b'
                } else {
                    nextCounts[j + 1] = (nextCounts[j + 1] + cnt) % MOD;
                }
            }

            counts = nextCounts;
        }

        // Sum all final counts
        long total = 0;
        for (long cnt : counts) {
            total = (total + cnt) % MOD;
        }

        return (int) total;
    }
}
