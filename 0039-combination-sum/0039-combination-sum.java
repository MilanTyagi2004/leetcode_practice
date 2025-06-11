class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    public void backtrace(int [] candidates,int target, int start,List<Integer> path, List<List<Integer>> res){
        if(target<0)return ;
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        for(int i =start;i<candidates.length;i++){
            path.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i, path, res); // not i+1 since we can reuse elements
            path.remove(path.size() - 1); // backtrack
        }
    }
}