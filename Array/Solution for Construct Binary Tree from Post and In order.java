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
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = inorder.length - 1;
        
        for (int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        
        return insertNode(size, 0, size, postorder, map);
    }
	
	TreeNode insertNode(int postind, int instart, int inend, int[] postorder, Map<Integer, Integer> map) {
		if (instart > inend) return null;
		
		int inindex = map.get(postorder[postind]);
		
		TreeNode treeNode = new TreeNode(postorder[postind]);
		treeNode.left = insertNode(postind-(inend-inindex+1), instart, inindex-1, postorder, map);
		treeNode.right = insertNode(postind-1, inindex+1, inend, postorder, map);

		return treeNode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
	}
}