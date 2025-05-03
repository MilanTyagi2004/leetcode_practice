public class Solution {
    public int minDominoRotations(int[] top, int[] bottom) {
        // Helper function to check the minimum rotations for a given target value
        int rotations = check(top, bottom, top[0]);
        if (rotations != -1 || top[0] == bottom[0]) {
            return rotations;
        }
        return check(top, bottom, bottom[0]);
    }

    private int check(int[] top, int[] bottom, int target) {
        int topRotations = 0;
        int bottomRotations = 0;
        for (int i = 0; i < top.length; i++) {
            if (top[i] != target && bottom[i] != target) {
                return -1;  // If neither row contains the target value, return -1
            }
            if (top[i] != target) {
                topRotations++;  // Increment rotation count for the top row
            } else if (bottom[i] != target) {
                bottomRotations++;  // Increment rotation count for the bottom row
            }
        }
        return Math.min(topRotations, bottomRotations);  // Return the minimum of the two
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] top = {2, 1, 2, 4, 2, 2};
        int[] bottom = {3, 2, 3, 3, 4, 2};
        
        System.out.println(solution.minDominoRotations(top, bottom));  // Output: 2
    }
}
