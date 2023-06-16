public class RemoveNthNodeFromEndofLis {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 1;
        ListNode ls = head;
        while (ls.next != null) {
            size++;
            ls = ls.next;
        }
        ListNode rezult=new ListNode();
        while (size - n > 0) {
            size--;
            ls = ls.next;
        }
        return ls;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
