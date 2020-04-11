package suanfa;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Mechrevo
 * @version v1.0
 * 2020/3/27 15:17
 */
public class Solution_02 {
    public static void main(String[] args) {

        long l = 1000000000;
        int i =(int ) l % 10;
        System.out.println(i);
        System.out.println("=================");

        //[9]
        //[1,9,9,9,9,9,9,9,9,9]

        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next= new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println(ListNode.toString(addTwoNumbers2(l1, l2)));
    }

    // 初始版本
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode lick = res;

        int carry = 0;
        int temp = 0;
        while (l1 != null || l2 != null || carry != 0) {
            temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            lick.next = new ListNode(temp % 10);
            carry = temp / 10;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            lick = lick.next;
        }
        return res.next;
    }

    // 进化版本
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode lick = res;

        int carry = 0;
        int temp = 0;

        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + carry;
            lick.next = new ListNode(temp % 10);
            carry = temp / 10;
            l1 = l1.next;
            l2 = l2.next;
            lick = lick.next;
        }
        while (l1 != null) {
            temp = l1.val + carry;
            lick.next = new ListNode(temp % 10);
            carry = temp / 10;
            l1 = l1.next;
            lick = lick.next;
        }

        while (l2 != null) {
            temp = l2.val + carry;
            lick.next = new ListNode(temp % 10);
            carry = temp / 10;
            l2 = l2.next;
            lick = lick.next;
        }
        if (carry != 0) {
            lick.next = new ListNode(carry);
            lick = lick.next;
        }
        return res.next;
    }

    /**
     * 将链表数取出，转int 在相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        long res = getNum(l1) + getNum(l2);
        System.out.println(res);
        ListNode result = new ListNode(-1);
        ListNode node = result;
        do {
            node.next = new ListNode((int) (res % 10));
            res = res / 10;
            node = node.next;
        }while ((res > 0));
        return result.next;
    }

    private static long getNum(ListNode listNode) {
        long position = 1; // 表示，第几位
        long res = 0;
        while (listNode != null) {
            res += listNode.val * position;
            position *= 10;
            listNode = listNode.next;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static String toString(ListNode listNode) {
        if (listNode == null)
            return "";
        if (listNode.next != null) {
            return "(" + listNode.val + ") -> " + toString(listNode.next);
        } else {
            return "(" + listNode.val + ")";
        }

    }

}
