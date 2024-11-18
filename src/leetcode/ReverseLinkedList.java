package leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode node = new ListNode(1, new ListNode(2));

        ListNode answer = reverseList(node);
        System.out.println(answer);
    }

    public static ListNode reverseList(ListNode head) {

        while(head.next != null) {
            ListNode prev = head.next;
            prev.next = head;
            prev = head;
        }

        return head;
    }

}
