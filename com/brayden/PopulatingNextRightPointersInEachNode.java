package com.brayden;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode extends LeetcodeTree {
	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		
        Queue<TreeLinkNode> curQ = new ArrayDeque<>();
        Queue<TreeLinkNode> nextLevelQ = new ArrayDeque<>();
        curQ.offer(root);
        TreeLinkNode preNode = null, curNode;
        while(true){
            while(!curQ.isEmpty()){
        	    curNode = curQ.poll();
        	    if(curNode.left != null)
            	    nextLevelQ.add(curNode.left);
            	if(curNode.right != null)
        	        nextLevelQ.add(curNode.right);
        	    
        	    if(preNode != null)
        	    	preNode.next = curNode;
        	    preNode = curNode;
            }
            //curNode.next = null; //no need, every node.next is inited null
            if(nextLevelQ.isEmpty())
            	return;
            preNode = null;
//            curQueue.addAll(nextLevelQueue);
//            nextLevelQueue.clear();
            Queue<TreeLinkNode> tmpQ = curQ;
            curQ = nextLevelQ;
            nextLevelQ = tmpQ;
        }
	}
	
	/**
	 * The tree is a perfect binary tree, so the code below works:
	 * (so the pre is the leftmost node on one level)
    if (root == NULL) return;
    TreeLinkNode *pre = root;
    TreeLinkNode *cur = NULL;
    while(pre->left) {
        cur = pre;
        while(cur) {
            cur->left->next = cur->right;
            if(cur->next) cur->right->next = cur->next->left;
            cur = cur->next;
        }
        pre = pre->left;
    }
	 */
}
