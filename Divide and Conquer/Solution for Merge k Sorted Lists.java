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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // method 1  O(N*logK)
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists.length == 0) return null;
    //     ListNode root = new ListNode(0);
    //     ListNode tmp = root;
    //     Queue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
    //         @Override
    //         public int compare(ListNode l1, ListNode l2) {
    //             return l1.val - l2.val;
    //         }
    //     });
    //     for (ListNode list : lists) {
    //         if (list != null)
    //             pq.add(list);
    //     }
    //     while (pq.size() != 0) {
    //         ListNode removed = pq.poll();
    //         tmp.next = new ListNode(removed.val);
    //         tmp = tmp.next;
    //         if (removed.next != null) pq.add(removed.next);
    //     }
    //     return root.next;
    // }
    
    // method 2 divide and conquer  O(N*logK)
    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1, size = lists.length;
        while (interval < size) {
            for (int i = 0; i < size-interval; i += 2*interval) {
                lists[i] = merge(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists.length == 0 ? null : lists[0];
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
                tmp = tmp.next;
            } else {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if (l1 == null) tmp.next = l2;
        if (l2 == null) tmp.next = l1;
        return head.next;
    }
}