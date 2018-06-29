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
    // method 1
    // public boolean isAnagram(String s, String t) {
    //     if (t.length() != s.length()) return false;
    //     int count = s.length();
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char ch : s.toCharArray()) {
    //         map.put(ch, map.getOrDefault(ch, 0)+1);
    //     }
    //     for (char ch : t.toCharArray()) {
    //         if (!map.containsKey(ch) || map.get(ch) == 0) return false;
    //         map.put(ch, map.get(ch)-1);
    //         count -= 1;
    //     }
    //     return count == 0;
    // }
    
    // method 2
    public boolean isAnagram(String s, String t) {
        int[] contain = new int[26];
        for (char ch : s.toCharArray()) {
            contain[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            contain[ch-'a']--;
        }
        for (int f : contain) {
            if (f != 0) return false;
        }
        return true;
    }
}