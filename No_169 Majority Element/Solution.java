public class Solution {
    public int majorityElement(int[] num) {
        int mid = num.length >> 1;
        if (mid == 0)
            return num[0];
        int start = 0;
        int end = num.length - 1;
        int index = partition(num, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
                index = partition(num, start, end);
            }
            else {
                start = index + 1;
                index = partition(num, start, end);
            }
        }

        return num[mid];
    }

    public int partition(int[] num, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = num[low];
        while (true) {
            while (num[++i] < v) {
                if (i == high)
                    break;
            }
            while (v < num[--j]) {
                if (j == low)
                    break;
            }
            if (i >= j)
                break;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        int temp = num[low];
        num[low] = num[j];
        num[j] = temp;

        return j;
    }
}