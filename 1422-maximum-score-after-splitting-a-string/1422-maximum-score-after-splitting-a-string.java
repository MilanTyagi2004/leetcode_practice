class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        int bestScore = Integer.MIN_VALUE;
        int zerosCount = 0;
        int onesCount =0;
        for(char ch :s.toCharArray()){
            if(ch =='1') totalOnes++;
        }

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0')zerosCount++;
            else onesCount++;
            int currentScore = zerosCount+(totalOnes-onesCount);
            bestScore = Math.max(bestScore,currentScore);
        }
        return bestScore;
    }
}