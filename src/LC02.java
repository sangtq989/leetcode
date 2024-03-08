
public class LC02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode node2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        Solution s = new Solution();
        System.out.println(s.linkedListToString( s.addTwoNumbers(node1, node2)));
    }
}

class ListNode {
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

class Solution {
    // Recursive function to convert a linked list to a string
    public String linkedListToString(ListNode head) {
        if (head == null) {
            return "null";
        } else if (head.next == null) {
            return Integer.toString(head.val);
        } else {
            return head.val + " -> " + linkedListToString(head.next);
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addRecursive(0, l1, l2);
    }


    static ListNode addRecursive(int carry, ListNode currentNode, ListNode currentNode2) {

        if (currentNode == null && currentNode2 == null) {
            if (carry > 0) return new ListNode(carry);
            return null;
        }

        if (currentNode2 == null) {
            int sum = currentNode.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            return new ListNode(sum, addRecursive(carry, currentNode.next, null));
        } else if (currentNode == null) {
            int sum = currentNode2.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            return new ListNode(sum, addRecursive(carry, null, currentNode2.next));
        } else {
            int sum = currentNode.val + currentNode2.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            return new ListNode(sum, addRecursive(carry, currentNode.next, currentNode2.next));
        }
    }

}