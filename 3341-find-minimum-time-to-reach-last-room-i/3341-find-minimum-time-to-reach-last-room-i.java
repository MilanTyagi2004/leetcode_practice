class Solution {
   static public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length, c = moveTime[0].length;
        int[][] minimumTime = new int[r][c];
        for (int[] is : minimumTime) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.steps - b.steps);

        pq.add(new Pair(-1, 0, 0));
        
        minimumTime[0][0] = 0;
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int i = top.i, j = top.j, nextStep = top.steps + 1;
            if (i + 1 < r) {
                if (nextStep < moveTime[i + 1][j]) nextStep = moveTime[i + 1][j];
                if (minimumTime[i + 1][j] > nextStep) {
                    pq.add(new Pair(nextStep, i + 1, j));
                    minimumTime[i + 1][j] = nextStep;
                }
            }

            nextStep = top.steps + 1;
            if (i - 1 >= 0) {
                if (nextStep < moveTime[i - 1][j])  nextStep = moveTime[i - 1][j];
                if (minimumTime[i - 1][j] > nextStep) {
                    pq.add(new Pair(nextStep, i - 1, j));
                    minimumTime[i - 1][j] = nextStep;
                }
            }

            nextStep = top.steps + 1;
            if (j - 1 >= 0) {
                if (nextStep < moveTime[i][j - 1]) nextStep = moveTime[i][j - 1];
                if (minimumTime[i][j - 1] > nextStep) {
                    pq.add(new Pair(nextStep, i, j - 1));
                    minimumTime[i][j - 1] = nextStep;
                }
            }
            nextStep = top.steps + 1;

            if (j + 1 < c) {
                if (nextStep < moveTime[i][j + 1]) nextStep = moveTime[i][j + 1];
                if (minimumTime[i][j + 1] > nextStep) {
                    pq.add(new Pair(nextStep, i, j + 1));
                    minimumTime[i][j + 1] = nextStep;
                }
            }

        }
        return minimumTime[r-1][c-1] + 1;
    }

}

class Pair {
    int steps = 0, i = -1, j = -1;

    public Pair(int steps, int i, int j) {
        this.steps = steps;
        this.i = i;
        this.j = j;
    }
}