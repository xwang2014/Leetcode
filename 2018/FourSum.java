class FourSum {
    
    // Four Sum Hashmap Solution
    // refer : https://soulmachine.gitbooks.io/algorithm-essentials/cpp/linear-list/array/4sum.html
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        
        // Build a cache -- use a hashmap to store the sum of two numbers
        Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!map.containsKey(nums[i] + nums[j])) {
                    List<int[]> list = new ArrayList<int[]>();
                    map.put(nums[i] + nums[j], list);
                }
                
                map.get(nums[i] + nums[j]).add( new int[] {i, j});
            }
        }
        
        // iterate 
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int rest = target - nums[i] - nums[j];
                
                if (map.containsKey(rest)) {
                    List<int[]> temp = map.get(rest);
                    
                    for(int[] arr : temp) {
                        if (arr[1] >= i) continue; // dup
                        
                        List<Integer> list = Arrays.asList(nums[arr[0]], nums[arr[1]], nums[i], nums[j]);
                        set.add(list);
                    }
                } 
            }
        }
        
        ans.addAll(set);
        return ans;
    }
}
