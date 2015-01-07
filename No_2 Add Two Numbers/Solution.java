/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */ 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = l1;
        ListNode secondNode = l2;

        int carryFlag = 0;
        while (firstNode.next != null && secondNode.next != null) {
            int temp = firstNode.val + secondNode.val + carryFlag;
            if (temp >= 10) {
                carryFlag = 1;
                temp = temp % 10;
            }
            else carryFlag = 0;
            secondNode.val = temp;
            
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        
        if (firstNode.next == null && secondNode.next == null) {
            int temp = firstNode.val + secondNode.val + carryFlag;
            if (temp >= 10) {
                carryFlag = 1;
                secondNode.val = temp % 10;
                ListNode newNode = new ListNode(carryFlag);
                secondNode.next = newNode;
                return l2;
            }
            else {
                secondNode.val = temp;
                return l2;
            }
        }
        
        if (firstNode.next != null) 
            secondNode.next = firstNode.next;
        int temp = firstNode.val + secondNode.val + carryFlag;
        if (temp >= 10) {
            carryFlag = 1;
            temp = temp % 10;
        }
        else carryFlag = 0;
        secondNode.val = temp;
        secondNode = secondNode.next;  

        while (secondNode.next != null) {
            temp = secondNode.val + carryFlag;
            if (temp >= 10) {
                carryFlag = 1;
                temp = temp % 10;
            }
            else carryFlag = 0;
            secondNode.val = temp;            
            secondNode = secondNode.next;
        }
        temp = secondNode.val + carryFlag;
        if (temp >= 10) {
            carryFlag = 1;
            secondNode.val = temp % 10;
            ListNode newNode = new ListNode(carryFlag);
            secondNode.next = newNode;
            return l2;
        }
        else {
            secondNode.val = temp;
            return l2;
        }
    }
}