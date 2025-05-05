class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length-1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i] +=1;
                return digits;
            }
            digits[i] = 0;
        }
        int [] newdig = new int[n+2];
        newdig[0]=1;
        return newdig;
    }
}