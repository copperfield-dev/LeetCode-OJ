public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || start.length() == 0
         || end == null || end.length() == 0 || start.length() != end.length())
            return 0;

        int distance = bfs(start, end, dict);
        return distance;
    }

    private int bfs(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        int distance = 1;
        int levelCount = 1;
        int curCount = 0;
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            levelCount--;
            for (int i = 0; i < cur.length(); i++) {
                StringBuilder temp = new StringBuilder(cur);
                for (char c = 'a'; c <= 'z'; c++) {
                    temp.setCharAt(i, c);
                    if (temp.toString().equals(end))
                        return distance + 1;
                    if (dict.contains(temp.toString()) && !visited.contains(temp.toString())) {
                        curCount++;
                        queue.offer(temp.toString());
                        visited.add(temp.toString());
                    }
                }
            }
            if (levelCount == 0) {
                levelCount = curCount;
                curCount = 0;
                distance++;
            }
        }
        return 0;
    }
}