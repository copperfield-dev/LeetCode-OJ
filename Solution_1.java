import java.util.*;

public class Solution_1 {
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();

    for (int i = 0; i < numbers.length; i++) {
      if (!hashMap.containsKey(numbers[i])) {
        hashMap.put(numbers[i], new ArrayList<Integer>());
      }
      hashMap.get(numbers[i]).add(i);
    }

    for (int i = 0; i < numbers.length - 1; i++) {
      if (hashMap.containsKey(target - numbers[i])) {
        for (int j : hashMap.get(target - numbers[i])) 
          if (j > i)
            return new int[] {i + 1, j + 1};
      }
    }

    return new int[] {-1, -1};
  }
}