class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100]; // Since max value of each a, b is 1-9, max key is 9*10+9 = 99
        int count = 0;
        
        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            int key = a * 10 + b;
            count += map[key];
            map[key]++;
        }
        
        return count;
    }
}
