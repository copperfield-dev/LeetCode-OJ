public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> answerSet = new LinkedList<List<Integer>>();
        if (num == null || num.length < 3)
            return answerSet;

        Arrays.sort(num);
        for (int i = num.length - 1; i >= 2; i--) {
            if (i < num.length - 1 && num[i] == num[i + 1])
                continue;
            ArrayList<ArrayList<Integer>> curAnswer = twoSum(num, i - 1, -num[i]);
            for(int j = 0; j < curAnswer.size(); j++)
                curAnswer.get(j).add(num[i]);    
            
            answerSet.addAll(curAnswer);  
        }
        return answerSet;
    }

    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
        ArrayList<ArrayList<Integer>> answerSet = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 2)
            return answerSet;

        int lo = 0;
        int hi = end;
        while (lo < hi) {
            if (num[lo] + num[hi] == target) {
                ArrayList<Integer> subAnswer = new ArrayList<Integer>();
                subAnswer.add(num[lo]);
                subAnswer.add(num[hi]);
                answerSet.add(subAnswer);
                lo++;
                hi--;
                while (lo < hi && num[lo] == num[lo - 1])
                    lo++;
                while (lo < hi && num[hi] == num[hi + 1])
                    hi--;
            }
            else if (num[lo] + num[hi] > target)
                hi--;
            else if (num[lo] + num[hi] < target)
                lo++;   
        }

        return answerSet;
    }
}