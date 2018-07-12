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
import java.util.LinkedList;
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

class Solution {
    //     method 1
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         traversal(root, ans);
//         return ans;
//     }
    
//     private void traversal(TreeNode node, List<Integer> ans) {
//         if (node == null) return;
//         traversal(node.left, ans);
//         ans.add(node.val);
//         traversal(node.right, ans);
//     }
    
    // method 2
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         Stack<TreeNode> S = new Stack();
//         Set<TreeNode> set = new HashSet();
        
//         if (root == null) return ans;
        
//         S.push(root);
//         while (!S.empty()) {
//             TreeNode tmp = S.peek();
//             if (tmp.left == null || set.contains(tmp.left)) {
//                 ans.add(tmp.val);
//                 S.pop();
//                 set.add(tmp);
//                 if (tmp.right != null) S.push(tmp.right);
//             } else {
//                 S.push(tmp.left);
//             }
//         }
        
//         return ans;
//     }
    
    // method 3
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> S = new Stack();

        
        while (root != null || !S.empty()) {
            if (root != null) {
                S.push(root);
                root = root.left;
            }
            else {
                root = S.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        
        return ans;
    }
}