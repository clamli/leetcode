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
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<Integer>();
        List<Integer> LB = new ArrayList<Integer>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < N*N; i++) {
            if (A[i/N][i%N] == 1) LA.add(i/N*100 + i%N);
        }
        for (int i = 0; i < N*N; i++) {
            if (B[i/N][i%N] == 1) LB.add(i/N*100 + i%N);
        }
        for (int i : LA) {
            for (int j : LB) {
                count.put(i-j, count.getOrDefault(i-j, 0)+1);
            }
        }
        int ans = 0;
        for (int num : count.values()) {
            ans = Math.max(ans, num);
        }
        return ans;
    }
}