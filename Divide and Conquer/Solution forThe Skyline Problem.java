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
    public List<int[]> getSkyline(int[][] buildings) {
        int n = buildings.length;
        if (n == 0) return new ArrayList<>();
        List<int[]> sortx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortx.add(new int[] {buildings[i][0], -buildings[i][2]});
            sortx.add(new int[] {buildings[i][1], buildings[i][2]});
        }
        Collections.sort(sortx, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        Queue<Integer> pq = new PriorityQueue<>(n, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.add(0);
        int maxheight = 0;
        List<int[]> res = new ArrayList<>();
        for (int[] x_h : sortx) {
            if (x_h[1] < 0) {
                pq.add(-x_h[1]);
            } else {
                pq.remove(x_h[1]);
            }
            int curmaxheight = pq.peek();
            if (maxheight != curmaxheight) {
                res.add(new int[] {x_h[0], curmaxheight});
                maxheight = curmaxheight;
            }
        }
        return res;
    }
}