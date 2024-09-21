package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        boolean result = false;
        Set<Integer> valSet = new HashSet<>();
        valSet.add(head.val);

        while (head.next != null) {
            ListNode next = head.next;
            if (valSet.contains(next.val)) {
                result = true;
                break;
            } else {
                valSet.add(next.val);
                head = next;
            }
        }

        return result;
    }

}
