class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    public void backtrace(int[] candidates,int target,int start, List<Integer>path,List<List<Integer>>res){
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        for(int i =start;i<candidates.length;i++){
            // to skip the duplicates
             if (i > start && candidates[i] == candidates[i - 1]) continue;

            // if current number is greater than target, no need to proceed
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i+1, path, res); // not i+1 since we can reuse elements
            path.remove(path.size() - 1); // backtrack
        }
    
    }
}