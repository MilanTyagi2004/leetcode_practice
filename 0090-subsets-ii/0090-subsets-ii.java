class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res  =new ArrayList<>();
        subset(0,nums,new ArrayList<>(),res);
        return res;
    }
    public void subset(int ind, int[] nums,List<Integer>path,List<List<Integer>>res){
        res.add(new ArrayList<>(path));

        for(int i=ind;i<nums.length;i++){
            if(i !=ind&&nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            subset(i+1,nums,path,res);
            path.remove(path.size()-1);
        }
    }
}