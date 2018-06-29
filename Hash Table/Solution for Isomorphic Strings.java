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
    public boolean isIsomorphic(String s, String t) {
        // method 1
        // Map<Character, Character> map = new HashMap<>();
        // Set<Character> set = new HashSet<>();
        // for (int i = 0; i < s.length(); i++) {
        //     if (!map.containsKey(s.charAt(i))) {
        //         if (!set.contains(t.charAt(i))) {
        //             map.put(s.charAt(i), t.charAt(i));
        //             set.add(t.charAt(i));
        //         } 
        //         else return false;
        //     } else if (map.get(s.charAt(i)) != t.charAt(i)) {
        //         return false;
        //     }
        // }
        // return true;
        
        // method 2
        int[] sarr = new int[128], tarr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (sarr[s.charAt(i)] == 0) {
                if (tarr[t.charAt(i)] == 0) {
                    sarr[s.charAt(i)] = t.charAt(i);
                    tarr[t.charAt(i)] = t.charAt(i);
                }
                else return false;
            } else if (sarr[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}