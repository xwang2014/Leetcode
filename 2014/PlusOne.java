
class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i];
            if(i == digits.length - 1) cur++;
            int res = cur + carry;
            digits[i] = res % 10;
            carry = res / 10;
        }
        
        int[] answer = null;
        if(carry != 0) {
            answer = new int[digits.length + 1];
            answer[0] = carry;
            for(int i = 0; i < digits.length; i++) answer[i+1] = digits[i];
        } else {
            answer = new int[digits.length];
            for(int i = 0; i < digits.length; i++) answer[i] = digits[i];
        }
        
        return answer;
    }


}
