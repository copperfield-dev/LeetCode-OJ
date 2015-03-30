public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0)
            return;
        
        int i = num.length - 2;
        for (; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                int min = Integer.MAX_VALUE;
                int minIndex = num.length;
                for (int j = num.length - 1; j > i; j--) {
                    if (num[j] < min && num[j] > num[i]) {
                        min = num[j];
                        minIndex = j;
                    }  
                }
      
                int temp = num[i];
                num[i] = min;
                num[minIndex] = temp;
                Arrays.sort(num, i + 1, num.length);
                break;
            }
        }
        if (i == -1)
            Arrays.sort(num);
        return;
    }
}