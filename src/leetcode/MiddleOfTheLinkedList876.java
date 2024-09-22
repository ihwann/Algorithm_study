package leetcode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */



public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5, null))))));
        middleNode(listNode);
    }

    private static ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode tmpNode = head;

        int depth = 0;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            depth++;
        }

        int pivot = 0;
        if (depth % 2 == 0) {
            pivot = depth / 2;
        } else {
            pivot = depth / 2 + 1;
        }

        int addCnt = 1;
        //ListNode answer = null;
        while (head.next != null) {
            head = head.next;
            if (addCnt == pivot) {
                break;
            }
            addCnt++;
        }

        return head;
    }
}
