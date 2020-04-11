package suanfa;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author Mechrevo
 * @version v1.0
 * 2020/4/8 22:10
 */
public class Solution_6 {
    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 3));
    }

    /**
     * 按行逐一添加，第0行和第numRows-1行只有一个
     * 中间的行数，有两个元素
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuffer sb = new StringBuffer();
        int carry = numRows * 2 - 2;
        int times = s.length() / carry + (s.length() % carry > 0 ? 1 : 0);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < times; j++) {
                if(j * carry + i >= s.length()) break;
                sb.append(s.charAt(j * carry + i));
                if (i > 0 && i < numRows - 1) {
                    if((j + 1) * carry - i >= s.length()) break;
                    sb.append(s.charAt((j + 1) * carry - i));
                }
            }
        }
        return sb.toString();


    }
}
