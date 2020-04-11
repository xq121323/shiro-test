package suanfa;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author Mechrevo
 * @version v1.0
 * 2020/4/7 13:42
 */
public class Solution_5 {
    public static void main(String[] args) {
        String res = longestPalindrome("ab");
        System.out.println(res);
    }

    /**
     * 每个中心检查一次是否为回文串
     * n长度的字符串有（2n+1）个中心，分奇偶
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n<2){
            return s;
        }
        int len = 1;
        int start = 0;
        for (int i = 0; i < (2 * n + 1); i++) {
            int left = i / 2;
            int right = (i+3) / 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (len < right - left + 1) {
                    len = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start,start + len);
    }

}
