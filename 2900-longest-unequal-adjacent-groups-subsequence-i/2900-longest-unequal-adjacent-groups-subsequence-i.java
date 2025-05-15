import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        // Try both possibilities: start with group 0 or group 1
        List<String> altStartWith0 = buildAlternating(words, groups, 0);
        List<String> altStartWith1 = buildAlternating(words, groups, 1);

        // Return the longer one
        return altStartWith0.size() >= altStartWith1.size() ? altStartWith0 : altStartWith1;
    }

    private List<String> buildAlternating(String[] words, int[] groups, int startGroup) {
        List<String> result = new ArrayList<>();
        int expectedGroup = startGroup;

        for (int i = 0; i < words.length; i++) {
            if (groups[i] == expectedGroup) {
                result.add(words[i]);
                expectedGroup ^= 1; // flip between 0 and 1
            }
        }

        return result;
    }
}
