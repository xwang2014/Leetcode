

public class MaximumSwap {


    public int maximumSwap(int num) {
        char[] arr = ("" + num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int digit = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (digit > i && arr[j] >= arr[digit]) {
                    digit = j;
                } else if (digit == i && arr[j] > arr[digit]) {
                    digit = j;
                }
            }
            if (digit > i) {
                char temp = arr[i];
                arr[i] = arr[digit];
                arr[digit] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        MaximumSwap so = new MaximumSwap();

        int ans = so.maximumSwap(98368);

        System.out.println(ans);
    }

}


