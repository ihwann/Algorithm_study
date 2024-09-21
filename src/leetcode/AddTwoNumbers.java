package leetcode;

public class AddTwoNumbers {


    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(10/10);
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        addNode(result, l1, l2, 0);
        return result.next;
    }

    private static void addNode(ListNode result, ListNode l1, ListNode l2, int carry) {
        while (l1 != null || l2 != null || carry != 0) {
            int total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            carry = total / 10;
            total = total % 10;


            result.next = new ListNode(total);
            result = result.next;
        }
    }
}
