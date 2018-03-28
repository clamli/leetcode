package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.text.DateFormatSymbols;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int size = preorder.length;
//        if (size == 0) {
//        	TreeNode T = null;
//        	return T;
//        }
//        
//        for (int i = 0; i < size; i++) {
//        	map.put(inorder[i], i);
//        }
//
//        
//        TreeNode T = new TreeNode(preorder[0]), Tp = null;
//        for (int i = 1; i < size; i++) {
//        	Tp = T;
//        	while (true) {
//        		int topind = map.get(Tp.val);
//        		int curind = map.get(preorder[i]);
//    			if (topind < curind) {
//    				if (Tp.right != null) {
//    					Tp = Tp.right;
//    				} else {
//    					Tp.right = new TreeNode(preorder[i]);	
//    					break;
//    				}
//    			} else if (topind > curind) {
//    				if (Tp.left != null) {
//    					Tp = Tp.left;
//    				} else {
//    					Tp.left = new TreeNode(preorder[i]);
//    					break;
//    				}
//    			}  			
//    		}
//        }
//        
//        return T;
//    }
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = preorder.length;
        
        for (int i = 0; i < size; i++) {
        	map.put(inorder[i], i);
        }

        return insertNode(0, 0, size-1, preorder, map);
	}
	
	TreeNode insertNode(int preindex, int instart, int inend, int[] preorder, Map<Integer, Integer> map) {
		if (instart > inend) return null;
		
		int root = preorder[preindex];
		int inindex = map.get(root);
		TreeNode T = new TreeNode(root);
		
		T.left = insertNode(preindex+1, instart, inindex-1, preorder, map);
		T.right = insertNode(preindex+inindex-instart+1, inindex+1, inend, preorder, map);
		
		return T;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
	}
}