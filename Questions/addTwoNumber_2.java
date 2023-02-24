public class addTwoNumber_2 {

    //Definition for singly-linked list.
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //逆序排列，表头是个位，从表头开始遍历
    //先创建一个虚拟的表头
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummy = new ListNode();//一个哑的头节点，就是head！
        ListNode curr = dummy;//curr是指针，指到最后相当于尾节点，tail！
        while (l1 != null || l2 != null) {//链表继续遍历的条件,l1或者l2还没遍历完
            carry=0;

            //链表如果有值就取该值，如果已经遍历完（null）了就都归为0
            int x = l1 != null ? l1.val: 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            //链表继续遍历的方式
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) curr.next = new ListNode(carry);
        return dummy.next;
    }


}
