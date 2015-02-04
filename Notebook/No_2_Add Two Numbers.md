# Add Two Numbers

[LeetCode|Linked List|Math]

## Problem

> You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

> Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
> Output: 7 -> 0 -> 8

## Solution

- 分别遍历两个链表，先遍历至其中一个结束
- 考虑三种情况考虑两个链表的长度：两个链表长度一致、链表1比链表2长、链表2比链表1长
- `我的思路是把结果存放在链表2中`
- 如果是把结果放在一个新的链表中，可以减少代码冗余

#### 附上LeetCode上大牛的解法代码

``` java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
```

## Application

- 可用于大整数加法