class Solution {
    int newNumber(int n){
        int sum=0;
        while(n!=0){
            int dig = n%10;
            sum += dig*dig;
            n=n/10;
        }
        
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast  =newNumber(n);
        while(fast!=1&&slow!=fast){
            slow = newNumber(slow);
            fast = newNumber(newNumber(fast));
        }
        return fast==1;
    }
}