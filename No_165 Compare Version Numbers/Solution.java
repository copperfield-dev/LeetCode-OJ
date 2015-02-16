public class Solution {
    public static int compareVersion(String version1, String version2) {
        StringBuffer v1 = new StringBuffer(version1);
        StringBuffer v2 = new StringBuffer(version2);

        int numOfV1;
        int numOfV2;
        int indexOfV1;
        int indexOfV2;
        do {
            indexOfV1 = v1.indexOf(".");
            indexOfV2 = v2.indexOf(".");

            numOfV1 = (indexOfV1 == -1) ? 
                Integer.parseInt(v1.substring(0)) : Integer.parseInt(v1.substring(0, indexOfV1));
            numOfV2 = (indexOfV2 == -1) ? 
                Integer.parseInt(v2.substring(0)) : Integer.parseInt(v2.substring(0, indexOfV2));

            if (numOfV1 > numOfV2)
                return 1;
            else if (numOfV1 < numOfV2)
                return -1;
            else {
                if (indexOfV1 == -1)
                    v1.replace(0, v1.length(), "0");
                else
                    v1.delete(0, indexOfV1 + 1);
                if (indexOfV2 == -1)
                    v2.replace(0, v2.length(), "0");
                else
                    v2.delete(0, indexOfV2 + 1);
            } 
        } while (indexOfV1 != -1 || indexOfV2 != -1);

        numOfV1 = Integer.parseInt(v1.substring(0));
        numOfV2 = Integer.parseInt(v2.substring(0));
        if (numOfV1 < numOfV2)
            return -1;
        else if (numOfV1 > numOfV2)
            return 1;
        else
            return 0;
    }
}