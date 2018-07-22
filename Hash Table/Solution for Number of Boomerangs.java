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
    public int numberOfBoomerangs(int[][] points) {
        int row = points.length;
        if (row == 0) return 0;
        int res = 0;
        Map<Integer, Integer> dist_cnt = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                int x = points[i][0]-points[j][0];
                int y = points[i][1]-points[j][1];
                int d = x*x + y*y;
                dist_cnt.put(d, dist_cnt.getOrDefault(d, 0)+1);
                int cnt = dist_cnt.get(d);
                if (cnt >= 2) res += 2*(cnt-1);
            }
            dist_cnt.clear();
        }
        return res;
    }
}