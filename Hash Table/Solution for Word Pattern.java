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
    public boolean wordPattern(String pattern, String str) {
        // method 1
        // Map<Character, List<Integer>> map = new HashMap<>();
        // String[] strs = str.split("\\s");
        // if (strs.length != pattern.length()) return false;
        // for (int i = 0; i < pattern.length(); i++) {
        //     char ch = pattern.charAt(i);
        //     if (map.containsKey(ch)) {
        //         map.get(ch).add(i);
        //     } else {
        //         map.put(ch, new ArrayList<>(Arrays.asList(i)));
        //     }
        // }
        // Set<String> removed = new HashSet<>();
        // for (List<Integer> idxs : map.values()) {
        //     if (removed.contains(strs[idxs.get(0)])) return false;
        //     for (int i = 1; i < idxs.size(); i++) {
        //         int idx1 = idxs.get(i-1), idx2 = idxs.get(i);
        //         if (!strs[idx1].equals(strs[idx2])) return false;
        //     }
        //     removed.add(strs[idxs.get(0)]);
        // }
        // return true;
        
        // method 2
        String[] strs = str.split("\\s");
        if (strs.length != pattern.length()) return false;
        String[] map = new String[256];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map[(int)ch] == null) {
                if (set.contains(strs[i])) return false;
                set.add(strs[i]);
                map[(int)ch] = strs[i];
            } else if (!map[ch].equals(strs[i])) {
                return false;
            }
        }
        return true;
    }
}