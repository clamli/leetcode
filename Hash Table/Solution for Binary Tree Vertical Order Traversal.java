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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<TreeNode, Integer> mcln = new HashMap<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Queue<Integer> Qc = new LinkedList<>();
        Q.offer(root);
        Qc.offer(0);
        while (Q.size() != 0) {
            TreeNode node = Q.poll();
            int cln = Qc.poll();
            if (!map.containsKey(cln)) map.put(cln, new ArrayList<>());
            map.get(cln).add(node.val);
            if(node.left != null) {
                Q.offer(node.left);
                Qc.offer(cln-1);
            }
            if(node.right != null) {
                Q.offer(node.right);
                Qc.offer(cln+1);
            }
        }
        return new ArrayList<>(map.values());
    }
    
    // private void inOrder(TreeNode node, Map<Integer, List<Integer>> map, int cln) {
    //     if (node == null) return;
    //     else {
    //         if (!map.containsKey(cln)) {
    //             map.put(cln, new ArrayList<>());
    //         }
    //         map.get(cln).add(node.val);
    //         inOrder(node.left, map, cln-1);
    //         inOrder(node.right, map, cln+1);
    //     }
    // }
}