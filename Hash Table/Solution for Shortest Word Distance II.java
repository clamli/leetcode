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
    Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> wdidx1 = map.get(word1), wdidx2 = map.get(word2);
        int res = Integer.MAX_VALUE, idx1, idx2;
        for (int i = 0, j = 0; i < wdidx1.size() && j < wdidx2.size();) {
            idx1 = wdidx1.get(i);
            idx2 = wdidx2.get(j);
            if (idx1 > idx2) {
                res = Math.min(res, idx1 - idx2);
                j++;
            } else {
                res = Math.min(res, idx2 - idx1);
                i++;
            }
        }
        return res;
    }
}