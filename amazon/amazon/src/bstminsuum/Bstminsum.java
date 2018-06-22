package bstminsuum;

public class Bstminsum {
	public static int solution(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right == null) {
			return solution(root.left) + root.val;
		}
		if (root.right != null && root.left == null) {
			return solution(root.right) + root.val;
		}
		
		return Math.min(solution(root.right), solution(root.left)) + root.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(8);
		TreeNode c = new TreeNode(7);
		TreeNode d = new TreeNode(6);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(3);
		TreeNode g = new TreeNode(1);
		b.left = d;
		b.right = a;
		d.left = f;
		d.right = c;
		f.left = g;
		f.right = e;
		System.out.println(solution(f));
	}

}
