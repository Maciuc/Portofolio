public class MergeTwoSortedList {
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

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode newList = new ListNode();
            while (list1 != null) {
                if (list1.val <= list2.val) {
                    newList.val = list1.val;
                    newList.next = null;

                    if (list1.next != null)
                        list1 = list1.next;
                    else
                        list2 = list2.next;
                }
            }
            while (list2!=null)
            {

                {
                    newList.val = list2.val;
                    newList.next = null;

                    if (list2.next!=null)
                        list2 = list2.next;
                    else
                        list2 = list2.next;
                }
            }
            return newList;
        }
    }
}
