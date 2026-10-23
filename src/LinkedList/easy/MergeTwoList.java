package LinkedList.easy;
import LinkedList.easy.ListNode;


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if(list1 != null){
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}
public class MergeTwoList {
    public static void main(String[] args){
        Solution sol = new Solution();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3); 
        list2.next.next = new ListNode(4);

        ListNode result = sol.mergeTwoLists(list1, list2);

        while (result != null) {
            System.out.println(result.val + " ");
            result = result.next;
        }
    }
}
