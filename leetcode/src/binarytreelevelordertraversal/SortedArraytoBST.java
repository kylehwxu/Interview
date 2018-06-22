package binarytreelevelordertraversal;

import java.util.Arrays;

public class SortedArraytoBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        int mid = nums.length/2 ;
        TreeNode n = new TreeNode(nums[mid]);
        
        helper(Arrays.copyOfRange(nums, 0, mid), n, 1);
    	System.out.println(n.left.val);

        helper(Arrays.copyOfRange(nums, mid + 1, nums.length), n, 0);
        return n;
    }
    
    public static void helper(int[] nums, TreeNode t, int lorr) {
        if(nums.length == 0) {
            return;
        } else if (nums.length == 1) {
        	if(lorr == 1) {
        		t.left = new TreeNode(nums[0]);
        	} else {
        		t.right = new TreeNode(nums[0]);
        	}
            return;
        }
        int mid = nums.length/2;
        t = new TreeNode(nums[mid]);
        helper(Arrays.copyOfRange(nums, 0, mid), t, 1);
        helper(Arrays.copyOfRange(nums, mid + 1, nums.length), t, 0);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2};
		sortedArrayToBST(a);

		
	}

}
