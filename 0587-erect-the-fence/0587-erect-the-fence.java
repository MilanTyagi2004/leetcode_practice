import java.util.*;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n <= 3) return trees;

        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<int[]> hull = new ArrayList<>();

        // Build lower hull
        for (int[] tree : trees) {
            while (hull.size() >= 2 && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), tree) < 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(tree);
        }

        // Build upper hull
        int lowerSize = hull.size();
        for (int i = n - 2; i >= 0; i--) {
            int[] tree = trees[i];
            while (hull.size() > lowerSize && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), tree) < 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(tree);
        }

        // Remove duplicates
        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (int[] p : hull) {
            String key = p[0] + "," + p[1];
            if (!seen.contains(key)) {
                result.add(p);
                seen.add(key);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    // Cross product to determine orientation
    private int cross(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - 
               (b[1] - a[1]) * (c[0] - a[0]);
    }
}
