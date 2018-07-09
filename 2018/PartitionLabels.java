
class Solution {

    // end pointers
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<Integer>();
        
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0, last = 0;
        int i = 0;
        
        while (i < S.length()) {
            last = Math.max(last, arr[S.charAt(i) - 'a']);
            
            if (last == i) {
                ans.add(last - start + 1);
                
                start = last + 1;
            } 
            i++;
        }
        
        return ans;
    }
    
    
    /* Solution 1 -- use interval merge 
    class Interval {
        int start;
        int end;
        
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    public List<Integer> partitionLabels(String S) {
        
        int[] start = new int[26];
        int[] end = new int[26];
        for (int i = 0; i < 26; i++) {
            start[i] = -1;
            end[i] = -1;
        }
        
        // compute start and end position of each character
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            int idx = (int)(c - 'a');
            if (start[idx] == -1) {
                start[idx] = i;
                end[idx] = i;
            } else {
                end[idx] = Math.max(end[idx], i);
            }
        }
        
        List<Interval> ins = new ArrayList<Interval>();
        for (int i = 0; i < 26; i++) {
            if (start[i] != -1) {
                Interval in = new Interval(start[i], end[i]);
                ins.add(in);
            }
        }
        
        Collections.sort(ins, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) {
                    return -1;
                } else if (i1.start > i2.start) {
                    return 1;
                } else {
                    return i1.end - i2.end;
                }
            }
        });
        
        List<Integer> ans = new ArrayList<Integer>();
        
        for (int i = 0; i < ins.size(); i++) {
            if (i < ins.size() - 1) {
                if (ins.get(i).end < ins.get(i + 1).start) {
                    ans.add(ins.get(i).end - ins.get(i).start + 1);
                } else {
                    ins.get(i + 1).start = Math.min(ins.get(i).start, ins.get(i + 1).start);
                    ins.get(i + 1).end = Math.max(ins.get(i).end, ins.get(i + 1).end);
                }
            } else {
                ans.add(ins.get(i).end - ins.get(i).start + 1);
            }
        }
        
        return ans;
    }
    */
}


