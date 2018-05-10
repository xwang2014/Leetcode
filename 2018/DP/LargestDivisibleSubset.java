
class Solution {
    
    // 1. sort
    // 2. f[n] means number of elements with array ending in n
    //    f[n] = Math.max      f[i] + 1  if n % i == 0
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if (nums == null || nums.length < 1) return ans;
        
        List<Set<Integer> > arr = new ArrayList< Set<Integer> >();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(nums[i]);
            arr.add(set);
            
            int sub = i - 1;
            int size = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && arr.get(j).size() > size) {
                    sub = j;
                    size = arr.get(j).size();
                }
            }
            
            if (size > 0) {
                arr.get(i).addAll(arr.get(sub));
            }
        }
        
        Set<Integer> large = new HashSet<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).size() > large.size()) {
                large = arr.get(i);
            }
        }
        
        ans.addAll(large);
        Collections.sort(ans);
        return ans;
    }
}


