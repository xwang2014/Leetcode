

class Solution {
    public String frequencySort(String s) {
        int[] map = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)] += 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character ch = new Character(s.charAt(i));
            arr[i] = ch;
        }
        
        Arrays.sort(arr, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                if (map[c1] == map[c2]) {
                    return c2 - c1;
                } else {
                    return map[c2] - map[c1];
                }                
            }

        });
        
        StringBuffer sb = new StringBuffer();
        for (Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}

