package com.nbf.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S002AddTwoNumbers {
    private static Logger logger = LoggerFactory.getLogger(S002AddTwoNumbers.class);

    public static void main(String[] args) {
        ListNode l2 = new ListNode(5);
        ListNode l1 = new ListNode(5);
        ListNode result = new S002AddTwoNumbers().addTwoNumbers(l1, l2);
        while (result != null) {
            logger.info(String.valueOf(result.val));
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int more = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + more;
            more = sum / 10;
            ListNode next = new ListNode(sum % 10);
            temp.next = next;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            joinTogether(temp, l1, more);
        }
        if (l2 != null) {
            joinTogether(temp, l2, more);
        }
        if (l1 == null && l2 == null && more != 0) {
            ListNode next = new ListNode(more);
            temp.next = next;
        }
        return result.next;

    }

    public void joinTogether(ListNode temp, ListNode last, int more) {
        while (more > 0 && last != null) {
            int sum = last.val + more;
            more = sum / 10;
            ListNode next = new ListNode(sum % 10);
            temp.next = next;
            temp = temp.next;
            last = last.next;
        }
        if (last != null) {
            temp.next = last;
        }
        if (more > 0) {
            ListNode next = new ListNode(more);
            temp.next = next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

   public ListNode(int x) {
        val = x;
    }
}
