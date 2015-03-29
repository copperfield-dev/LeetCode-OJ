public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> answerSet = new ArrayList<String>();
        if (s == null || s.length() < 10)
            return answerSet;

        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        charMap.put('A', 0);
        charMap.put('C', 1);
        charMap.put('G', 2);
        charMap.put('T', 3);
        Map<Integer, Integer> stringMap = new HashMap<Integer, Integer>();
        int stringCode = 0;
        for (int i = 0; i < s.length(); i++) {
            stringCode = ((stringCode << 2) + charMap.get(s.charAt(i))) & 0xFFFFF;
            if (i < 9)
                continue;
            Integer count = stringMap.get(stringCode);
            if (stringMap.containsKey(stringCode) 
                && stringMap.get(stringCode) == 1)
                answerSet.add(s.substring(i - 9, i + 1));
            stringMap.put(stringCode, (count == null)? 1 : count + 1);
        }
        return answerSet;
    }
}