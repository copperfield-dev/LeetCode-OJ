public class Solution {
    class TwoSum{
        public int index1;
        public int index2;
        public int sum;
        
        TwoSum(int index1, int index2, int sum){
            this.index1=index1;
            this.index2=index2;
            this.sum=sum;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> answerSet = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4)
            return answerSet;

        HashMap<Integer, List<TwoSum>> hashMap = 
            new HashMap<Integer, List<TwoSum>>();
        /* 将两个数的和存入HashMap */
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i]+num[j];
                TwoSum twoSum = new TwoSum(i, j, sum);
                if (!hashMap.containsKey(sum)) 
                    hashMap.put(sum, new ArrayList<TwoSum>());
                hashMap.get(sum).add(twoSum);
            }
        }

        Iterator hashIterator = hashMap.entrySet().iterator();
        while (hashIterator.hasNext()) {
            Map.Entry pairs = (Map.Entry)hashIterator.next();
            int sum = (Integer)pairs.getKey();
            List<TwoSum> twoSumListOne = (List<TwoSum>)pairs.getValue();
            List<TwoSum> twoSumListTwo = (List<TwoSum>)hashMap.get(target - sum);
        
            if (twoSumListTwo != null) {
                for (TwoSum twoSumFirst : twoSumListOne) {
                    for (TwoSum twoSumSecond : twoSumListTwo) {
                        // Avoid reuse of any elementwoSumFirst in num[]
                        if(twoSumFirst.index1 == twoSumSecond.index1 
                        || twoSumFirst.index1 == twoSumSecond.index2) 
                            continue;
                        if(twoSumFirst.index2 == twoSumSecond.index1
                        || twoSumFirst.index2 == twoSumSecond.index2) 
                            continue;
                        ArrayList<Integer> subAnswer = new ArrayList<Integer>();
                        subAnswer.add(num[twoSumFirst.index1]);
                        subAnswer.add(num[twoSumFirst.index2]);
                        subAnswer.add(num[twoSumSecond.index1]);
                        subAnswer.add(num[twoSumSecond.index2]);

                        Collections.sort(subAnswer);
                        // Add subAnswer into answerSet and ignore duplicated ones
                        if (!answerSet.contains(subAnswer))
                            answerSet.add(subAnswer);
                    }
                }
            }
            else
                continue;
        }

        return answerSet;
    }
}