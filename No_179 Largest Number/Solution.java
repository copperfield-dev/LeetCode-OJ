public class Solution {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0)
            return null;

        StringBuilder answer = new StringBuilder();
        String[] strs = new String[num.length];
        for (int i = 0; i < num.length; i++) 
            strs[i] = Integer.toString(num[i]);

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;

                return s2.compareTo(s1);
            }
        });

        for (int i = 0; i < strs.length; i++) 
            answer.append(strs[i]);

        if (answer.charAt(0) == '0')
            return "0";
        return answer.toString();
    }
}