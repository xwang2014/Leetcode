
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int start = 0, len = 1;
        map.put(s.charAt(0), 0);
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                int last = map.get(c);
                if (last >= start) {
                    start = map.get(c) + 1;
                }
                map.put(c, i);
            }
            len = Math.max(len, i - start + 1);
        }
        
        return len;
    }




