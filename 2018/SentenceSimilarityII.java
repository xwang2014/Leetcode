
class Solution {
    // Union Find
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        
        Map<String, Integer> wordToGroup = new HashMap<String, Integer>();
        Map<Integer, Set<String> > group = new HashMap<Integer, Set<String> >();
        int groupCnt = 0;
        
        for (int i = 0; i < pairs.length; i++) {
            if ( !wordToGroup.containsKey(pairs[i][0]) && !wordToGroup.containsKey(pairs[i][1])) {
                int groupNum = groupCnt++;
                
                wordToGroup.put(pairs[i][0], groupNum);
                wordToGroup.put(pairs[i][1], groupNum);
                
                Set<String> set = new HashSet<String>();
                set.add(pairs[i][0]);
                set.add(pairs[i][1]);
                
                group.put(groupNum, set);
            } else if (wordToGroup.containsKey(pairs[i][0]) && wordToGroup.containsKey(pairs[i][1])) {
                int g1 = wordToGroup.get(pairs[i][0]);
                int g2 = wordToGroup.get(pairs[i][1]);
                
                if (g1 != g2) {
                    // merge g1 into g2
                    Set<String> set1 = group.get(g1);
                    for (String k : set1) {
                        wordToGroup.put(k, g2);
                    }

                    Set<String> set2 = group.get(g2);
                    set2.addAll(set1);
                    group.remove(g1);
                }
            } 
            else if (wordToGroup.containsKey(pairs[i][0])) {
                int groupNum = wordToGroup.get(pairs[i][0]);
                
                group.get(groupNum).add(pairs[i][1]);
                wordToGroup.put(pairs[i][1], groupNum);
            } else if (wordToGroup.containsKey(pairs[i][1])) {
                int groupNum = wordToGroup.get(pairs[i][1]);
                
                group.get(groupNum).add(pairs[i][0]);
                wordToGroup.put(pairs[i][0], groupNum);
            }
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals (words2[i]) ) {
                continue;
            } else if (wordToGroup.containsKey(words1[i]) && group.get(wordToGroup.get(words1[i])).contains(words2[i])) {
                continue; 
            } else if (wordToGroup.containsKey(words2[i]) && group.get(wordToGroup.get(words2[i])).contains(words1[i])) {
                continue;                
            } else {
                return false;
            }
        }
    
        return true;
    }
}


