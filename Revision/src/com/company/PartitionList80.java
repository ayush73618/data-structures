package com.company;

public class PartitionList80 {
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
    public ListNode partition(ListNode head, int x) {

        ListNode left = new ListNode(0); // node which will contain element less than x and point toward them
        ListNode right = new ListNode(0);// node which contain element more than x and point toward them;
        ListNode leftTail = left; // to traversing so that we don't lose our starting point which will be important
        ListNode rightTail = right; //same here traversing

        while(head !=null){
            if(head.val <x){
                leftTail.next = head; //addressing that head value which is less than x to leftTail.next then leftTail will move forward
                leftTail = leftTail.next;
            }
            else{
                rightTail.next = head; //addressing that head value which is greater than x to rightTail.next then rightTail will move forward
                rightTail  = rightTail.next;
            }
            head = head.next;
        }

        //at this point
        //left = 0-1-2-2
        //right = 4-3-5

        //need to connect those two linked list

        leftTail.next = right.next; // now leftmost part will address the starting point of right
        rightTail.next = null; // and rightmost part should be null otherwise it will in infinite loop;

        return left.next;

    }

    public static void main(String[] args) {
        //partition linked list such that node value smaller than x will come right to x then everything else will be after that without
        // any disorder
        //ex 1-4-3-2-5-2
        // 1-2-2-4-3-5

    }
}
