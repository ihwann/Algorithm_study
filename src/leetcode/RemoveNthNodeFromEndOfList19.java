package leetcode;

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {
        ListNode2 listNode = new ListNode2(1, new ListNode2(2, new ListNode2(3, new ListNode2(4, new ListNode2(5, null)))));
        int n = 2;
        removeNthFromEnd(listNode, n);
    }

    private static ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 dummy = new ListNode2();
        dummy.next = head;

        // 더미 노드로부터 출발
        ListNode2 p1 = dummy;
        ListNode2 p2 = dummy;

        // p1과 p2 사이에 n 만큼의 갭을 생성
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }

        System.out.println();
        // p1이 마지막에 다다를 때까지 움직인다
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println();
        // 현재 p1 은 null이고 p2의 다음 노드가 삭제할 대상이다
        // 고로 p2의 다음은 p2의 다음의 다음으로 설정한다
        p2.next = p2.next.next;

        // dummy.next가 실질적인 head를 가리키고 있기 때문에 head 대신 dummy.next를 반환하는 것을 기억하자
        return dummy.next;
    }
}
