package LeetcodeProblems;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode outputNode = tempHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int newVal = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(newVal);
            outputNode.next = newNode;
            outputNode = outputNode.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = tempHead.next;
        tempHead.next = null;
        return result;
    }

    public static void testAddTwoNumbers(){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode sumNodes = AddTwoNumbers.addTwoNumbers(l1, l2);

        while(sumNodes != null){
            System.out.println("digits: " + l1.val + ", " + l2.val);
            System.out.println("sum: " + sumNodes.val);
            sumNodes = sumNodes.next;
            l1 = l1.next;
            l2 = l2.next;
        }
    }

}
