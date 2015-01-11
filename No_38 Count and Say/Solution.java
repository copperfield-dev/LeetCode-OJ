public class Solution {
    public static String countAndSay(int n) {
        int[] count = {0, 0, 0};
        String oldString = "1";

        String sayString = oldString;
        for (int i = 1; i < n; i++) {
            sayString = "";
            for (int j = 0; j < oldString.length(); j++) { 
                char curDigital = oldString.charAt(j);
                count[curDigital - '1']++;
                if (j == oldString.length() - 1) {
                    sayString += String.valueOf(count[0] + count[1] + count[2])
                           + String.valueOf(oldString.charAt(j));
                    for (int k = 0; k < 3; k++)
                        count[k] = 0;
                    break;
                }

                if (curDigital != oldString.charAt(j + 1)) {
                    sayString += String.valueOf(count[0] + count[1] + count[2]);
                    if (count[0] != 0) {
                        sayString += "1";
                        count[0] = 0;
                    }
                    else if (count[1] != 0) {
                        sayString += "2";
                        count[1] = 0;
                    }
                    else {
                        sayString += "3";
                        count[2] = 0;
                    }
                }
            }
            oldString = sayString;
        }

        return sayString;
    }
}