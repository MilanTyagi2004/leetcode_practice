class Solution {
    public int climbStairs(int n) {
        int first  =1;
        int second = 2;
        if(n==1)return 1;
        if(n==2)return 2;

        for(int i=3;i<=n;i++){
            int current  =first+second;
            first = second;
            second = current;
        }
        return second;
    }
}