class ThreeSum {
    
    // refer : https://gist.github.com/st0le/5893445
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        Set<List<Integer>> set = new HashSet<List<Integer>>(); //dedup
        
        for (int one = 0; one < nums.length - 1; one++) {
            map.clear();
            for (int two = one + 1; two < nums.length; two++) {
                
                if (map.containsKey(nums[two])) {
                    int[] temp = map.get(nums[two]);
                    List<Integer> list = Arrays.asList(temp[0], temp[1], nums[two]);
                    
                    set.add(list);
                    
                    while (two < nums.length - 1 && nums[two + 1] == nums[two]) two++;
                } else {
                    map.put(- nums[one] - nums[two], new int[] { nums[one], nums[two] });
                }
            }
        }
        
        ans.addAll(set);
        
        return ans;
    }
}



