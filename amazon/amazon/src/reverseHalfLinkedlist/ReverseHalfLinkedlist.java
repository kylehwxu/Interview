package reverseHalfLinkedlist;


public class ReverseHalfLinkedlist {
	public static ListNode reverseHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		
		prev.next = reverse(slow);
		
		return head;
		
	}
	
	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		
		while(head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode();
		ListNode temp = null;
		
		a.numberInlist = 1;
		a.next = new ListNode();
		temp = a.next;
		temp.numberInlist = 2;
		temp.next = new ListNode();
		temp = temp.next;
		temp.numberInlist = 3;
		temp.next = new ListNode();
		temp = temp.next;
		temp.numberInlist = 4;
		temp.next = new ListNode();
		temp = temp.next;
		temp.numberInlist = 5;
		temp.next = new ListNode();
		temp = temp.next;
		temp.numberInlist = 6;
		a = reverseHalf(a);
		while(a != null) {
			System.out.print(a.numberInlist);
			a = a.next;
		}
	}

}
