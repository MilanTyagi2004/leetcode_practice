class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        int[] forces = new int[n];

        // Apply force from right (R)
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                force = n; // Assign max force
            } else if (arr[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        // Apply force from left (L)
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                force = n;
            } else if (arr[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        // Build result based on net forces
        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0) result.append('R');
            else if (f < 0) result.append('L');
            else result.append('.');
        }

        return result.toString();
    }
}
