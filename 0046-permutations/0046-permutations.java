class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        findpermute(nums,path,res,freq);
        return res;
    }
    public void findpermute(int[] nums,List<Integer> path,List<List<Integer>> res,boolean[] freq){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                path.add(nums[i]);
                findpermute(nums,path,res,freq);
                path.remove(path.size()-1);
                freq[i]=false;
            }
        }
    }
}