class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class lc_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {

            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }

    public static void main(String[] args) {

        // Create common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // List A: 3 -> 7 -> 8 -> 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        // List B: 99 -> 8 -> 10
        ListNode headB = new ListNode(99);
        headB.next = common;

        lc_160 solution = new lc_160();

        ListNode intersection = solution.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}