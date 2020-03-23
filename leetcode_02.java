/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode sumListNode = new ListNode(0);
        sumListNode.next = null;
        ListNode tempList = sumListNode;
        

        int value = 0;
        int cal = 0;
        int temp = 0;
        while(l1!=null&&l2!=null)
        {
            temp = l1.val + l2.val + cal;
            value = temp%10;
            cal = temp/10;
            l1 = l1.next;
            l2 = l2.next;
            tempList.next = new ListNode(value);
            tempList = tempList.next;

        }

        while(l1!=null)
        {
            temp = l1.val + cal;
            value = temp%10;
            cal = temp/10;
            l1 = l1.next;
            tempList.next = new ListNode(value);
            tempList = tempList.next;
        }
        while(l2!=null)
        {
            temp = l2.val + cal;
            value = temp%10;
            cal = temp/10;
            l2 = l2.next;
            tempList.next = new ListNode(value);
            tempList = tempList.next;
        }
        
        if(cal == 1)
        {
            tempList.next = new ListNode(1);

        }
        return sumListNode.next;
    }
}