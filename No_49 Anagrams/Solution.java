public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> group = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr);
            if (hashMap.containsKey(str))
                hashMap.get(str).add(strs[i]);
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                hashMap.put(str, list);
            }
        }

        Iterator iter = hashMap.values().iterator();
        while (iter.hasNext()) {
            ArrayList<String> item = (ArrayList<String>)iter.next();
            if (item.size() > 1)      //符合Anagrams
                group.addAll(item);
        }

        return group;
    }
}