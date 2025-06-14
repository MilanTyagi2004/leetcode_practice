class Solution {
    public int trap(int[] height) {
        int []leftMax = leftPrefix(height);
        int[] rightMax = rightsuffix(height);

        int total =0;

        for(int i=0;i<height.length;i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            total += waterLevel - height[i];
        }
        return total;
    }
    public int[] leftPrefix(int []arr){
       int n=arr.length;
       int []prefix =new int[n];
       prefix[0] =arr[0];
       for(int i=1;i<n;i++){
        prefix[i] = Math.max(prefix[i-1],arr[i]);
       }
       return prefix;
    }
    public int[] rightsuffix(int arr[]){
        int n=arr.length;
       int []suffix =new int[n];
       suffix[n-1] =arr[n-1];
       for(int i=n-2;i>=0;i--){
        suffix[i] = Math.max(suffix[i+1],arr[i]);
       }
       return suffix;
    }
}