package binarytreelevelordertraversal;

import java.util.List;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> s = new LinkedList<List<Integer>>();
        marker(s, 0, root);
        return s;
    }
    
    public static void marker(List<List<Integer>> l, int level, TreeNode t) {
        if(t == null) {
            return;
        }
        if(level >= l.size()) {
            l.add(0, new LinkedList<Integer>());
        }
        marker(l, level+1, t.left);
        marker(l, level+1, t.right);
        l.get(l.size() - level + 1).add(t.val);
        System.out.println(level + ":" + t.val);
        System.out.println(l.get(level));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
		a.left=b;
		a.right=c;
		c.left = d;
		c.right = e;
		levelOrderBottom(a);
		
	}

}
