package suanfa;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author Mechrevo
 * @version v1.0
 * 2020/4/4 18:05
 */
public class Solution_03 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("a"));
    }

    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
                    break;
                } else {
                    temp++;
                }
            }
            res = (res > temp) ? res : temp;
        }
        return res;
    }

    /**
     * set集合
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        char c;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                } else {
                    set.add(c);
                }
            }
            set.clear();
        }
        return res;
    }

    /**
     * 滑动窗口方法，不存在时增加窗口长度，不存在时减少窗口长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int res = 0, i = 0, j = 0, len = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
                res= Math.max(len,res);
                len--;
            } else {
                set.add(s.charAt(j++));
                len++;
            }
        }
        return Math.max(len,res);
    }
}
