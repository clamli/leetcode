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
    public String minWindow(String s, String t) {
        // Map<Character, Integer> map_cnt = new HashMap<Character, Integer>();
        // for (char ch : t.toCharArray()) {
        //     map_cnt.put(ch, map_cnt.getOrDefault(ch, 0)+1);
        // }
        // List<Integer> key = new ArrayList<Integer>();
        // List<Character> val = new ArrayList<Character>();
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if (map_cnt.containsKey(ch)) {
        //         key.add(i);
        //         val.add(ch);
        //     }
        // }
        int[] char_cnt = new int[128];
        for (char ch : t.toCharArray()) {
            char_cnt[ch]++;
        }
        int count = 0, min = Integer.MAX_VALUE, ansl = -1, ansr = -1;
        // Map<Character, Integer> tmp = new HashMap<Character, Integer>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (char_cnt[s.charAt(i)] > 0) {
                count++;
            }
            char_cnt[s.charAt(i)]--;
            if (count == t.length()) {
                while (count == t.length()) {
                    char_cnt[s.charAt(left)]++;
                    if (char_cnt[s.charAt(left)] > 0) count--;
                    left++;
                }
                if (i - left + 1 < min) {
                    min = i - left + 1;
                    ansl = left - 1;
                    ansr = i;
                }
            }
        }
        if (ansl == -1) {
            return "";
        } else {
            return s.substring(ansl, ansr+1);
        }
            
        //     char ch = val.get(i);
        //     tmp.put(ch, tmp.getOrDefault(ch, 0)+1);
        //     if (tmp.get(ch) <= map_cnt.get(ch)) count++;
        //     if (count == t.length()) {
        //         char removed = val.get(left);
        //         while (tmp.get(removed) > map_cnt.get(removed)) {
        //             tmp.put(removed, tmp.get(removed)-1);
        //             left++;
        //             removed = val.get(left);
        //         }
        //         int diff = key.get(i)-key.get(left);
        //         if (diff < min) {
        //             min = diff;
        //             ansl = left;
        //             ansr = i;
        //         }
        //         removed = val.get(left);
        //         tmp.put(removed, tmp.get(removed)-1);
        //         count--;
        //         left++;
        //     }
        // }
        // if (ansl == -1) {
        //     return "";
        // } else {
        //     return s.substring(key.get(ansl), key.get(ansr)+1);
        // }   
    }
}