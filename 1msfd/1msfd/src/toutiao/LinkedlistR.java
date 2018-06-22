package toutiao;

class Node {
	int val;
	Node next;
	
	public Node(int val) {
		this.val = val;
	}
}

public class LinkedlistR {

	
	public Node solution(Node head) {
		Node dummy = new Node(-1);
		dummy.next = head;
		Node pre = dummy;
		Node end = null;
		while (head != null) {
			if (head.val % 2 == 0) {
				pre.next = head.next;
				head.next = end;
				end = head;
				head = pre.next;
			} else {
				if (head.next == null) {
					break;
				}
				pre = head;
				head = head.next;
			}
			
		}
		if (head != null) {
			head.next = end;
		} else {
			pre.next =end;
		}
		
		
		return reverse(dummy.next);
	}
	
	private Node reverse(Node head) {
		Node dummy = new Node(-1);
		dummy.next = head;
		Node pre = null;
		while (head.next != null) {
			dummy.next = head.next;
			head.next = pre;
			pre = head;
			head = dummy.next;
		}
		head.next = pre;
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(7);
        Node node4 = new Node(1);
        Node node5 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        LinkedlistR lr = new LinkedlistR();
        Node res = lr.solution(node1);
        while(res!= null) {
        	System.out.println(res.val);
        	res = res.next;
        }
	}

}
