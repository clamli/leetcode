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
    public int[] smallestRange(List<List<Integer>> nums) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> nums.get(e[0]).get(e[1])));
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[] {i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int start = 0, end = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            int e[] = pq.poll(), row = e[0], col = e[1];
            if (max - nums.get(row).get(col) < end - start) {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col + 1 < nums.get(row).size()) {
                pq.offer(new int[] {row, col+1});
                max = Math.max(max, nums.get(row).get(col+1));
            }
        }
        return new int[] {start, end};
    }
}