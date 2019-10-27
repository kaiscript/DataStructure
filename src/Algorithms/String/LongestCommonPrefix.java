package Algorithms.String;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    /**
     * 取前2个公共前缀，再遍历地取与后面每一个元素公共的前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefixVertical(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            //将第一个字符串的每个char，依次与后面的字符串中的char数组逐位比较
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || first.charAt(i) != strs[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }

        }
        return first;
    }


    /**
     * 分治方法解决
     * @param strs
     * @return
     */
    public static String longestCommonPrefixDiver(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        return longestCommonPrefixDiver(strs, 0, strs.length - 1);
    }

    public static String longestCommonPrefixDiver(String[] strs, int left, int right) {
        if (strs.length == 0) {
            return "";
        }
        if (left == right) {
            return strs[left];
        }
        int mid = left + (right - left) / 2;
        String leftStr = longestCommonPrefixDiver(strs, left, mid);
        String rightStr = longestCommonPrefixDiver(strs, mid + 1, right);
        return lcp(leftStr, rightStr);
    }

    public static String lcp(String leftStr, String rightStr) {
        int min = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < min; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, min);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixVertical(strs));
        System.out.println(longestCommonPrefixDiver(strs));
    }

}
