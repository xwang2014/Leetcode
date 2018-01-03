
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        
        Arrays.sort(candidates);
        
        List<Integer> buffer = new LinkedList<Integer>();
        dfs(res, buffer, 0, candidates, target, 0);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.addAll(res);
        
        return ans;        
    }
    
    private void dfs(Set<List<Integer>> res, List<Integer> buffer, int sum, int[] candidates, 
                     int target, int idx) {

        if (sum == target) {
            List<Integer> temp = new ArrayList<Integer>(buffer);
            res.add(temp);
            return;
        }
        
        if (sum > target || idx >= candidates.length) {
            return;
        }
        
        // pick current number
        buffer.add(candidates[idx]);
        dfs(res, buffer, sum + candidates[idx], candidates, target, idx + 1);
        buffer.remove(buffer.size() - 1);
        
        // not pick current number
        dfs(res, buffer, sum, candidates, target, idx + 1);
    }


