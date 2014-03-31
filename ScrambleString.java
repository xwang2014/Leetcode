
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1) return s1.equals(s2);
        if(s1.equals(s2)) return true;
        
        int[] v1 = new int[26];
        int[] v2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            int idx1 = (int)(s1.charAt(i) - 'a');
            int idx2 = (int)(s2.charAt(i) - 'a');
            v1[idx1]++;
            v2[idx2]++;
        }
        for(int i = 0; i < 26; i++) {
            if(v1[i] != v2[i]) return false;
        }
        
        
        for(int i = 1; i < s1.length(); i++) {
            String a1 = s1.substring(0, i), a2 = s1.substring(i, s1.length());
            String b1 = s2.substring(0, i), b2 = s2.substring(i, s2.length());
            if(isScramble(a1, b1) && isScramble(a2,b2)) return true;
            
            String bb1 = s2.substring(s2.length() - i), bb2 = s2.substring(0, s2.length() - i);
            if(isScramble(a1, bb1) && isScramble(a2, bb2)) return true;
        }
        
        return false;
    }


}
