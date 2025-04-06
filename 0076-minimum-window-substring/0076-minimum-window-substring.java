import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for characters in t
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Variables to track sliding window
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int have = 0, need = targetMap.size();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        // Expand the window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) && 
                windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                have++;
            }

            // Contract the window while it's valid
            while (have == need) {
                // Update result
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                // Try to shrink from the left
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (targetMap.containsKey(leftChar) && 
                    windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
