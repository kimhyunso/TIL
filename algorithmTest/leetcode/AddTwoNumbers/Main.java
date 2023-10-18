package leetcode.AddTwoNumbers;

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next){ this.val = val; this.next = next; }
}



public class Main {
    public static void main(String[] args){

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        for (ListNode node = result; node != null; node=node.next){
            System.out.println(node.val);
        }
        
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode();

        for (ListNode node = l1, nodeTwo = l2; node != null && nodeTwo != null; node = node.next, nodeTwo = nodeTwo.next){
            result.val = (node.val + nodeTwo.val) % 10;
            result.next = new ListNode();
            result = result.next;
        }
        return result;
    }
    
}
