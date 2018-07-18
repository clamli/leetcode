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
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (!map.containsKey(points[i][1]))
                map.put(points[i][1], new TreeSet<>());
            map.get(points[i][1]).add(points[i][0]);
        }
        int mid = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            List<Integer> list = new ArrayList<>(map.get(key));
            for (int i = 0, j = list.size()-1; i <= j; i++, j--) {
                if (mid == Integer.MAX_VALUE) mid = list.get(i) + list.get(j);
                else if (mid != list.get(i) + list.get(j)) return false;
            }
        }
        return true;
    }
}