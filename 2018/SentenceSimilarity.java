
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String, Set<String> > map = new HashMap<String, Set<String> >();
        
        for (int i = 0; i < pairs.length; i++) {
            if (!map.containsKey(pairs[i][0])) {
                map.put(pairs[i][0], new HashSet<String>());
            }
            if (!map.containsKey(pairs[i][1])) {
                map.put(pairs[i][1], new HashSet<String>());
            }
            
            map.get(pairs[i][0]).add(pairs[i][1]);
            map.get(pairs[i][1]).add(pairs[i][0]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            
            if ( words1[i].equals(words2[i]) ) {
                continue;
            }
            else if (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i]) ) {
                continue;
            }
            else if (map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i]) ) {
                continue;
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}


