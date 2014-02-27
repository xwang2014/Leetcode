
public class SortColors {
    public void sortColors(int[] A) {
        if(A == null || A.length <= 1) return;
        if(A.length == 2) {
            if(A[0] > A[1]) {
                int temp = A[0];
                A[0] = A[1];
                A[1] = temp;
            }
            return;
        }
        int left = 0, right = A.length - 1;
        
        int index = 0;
        while(index <= right) {
            if(A[index] == 0) {
                int temp = A[left];
                A[left] = A[index];
                A[index] = temp;
                left++;
                index++;
            } else if(A[index] == 2) {
                int temp = A[right];
                A[right] = A[index];
                A[index] = temp;
                right--;
            } else index++;
        }
    }


}
