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
    // public int numMatchingSubseq(String S, String[] words) {
    //     HashMap<Character, TreeSet<Integer>> map = new HashMap<Character, TreeSet<Integer>>();
    //     for (int i = 0; i < S.length(); i++) {
    //         map.computeIfAbsent(S.charAt(i), k -> new TreeSet<Integer>()).add(i);
    //     }
    //     int ans = 0;
    //     for (int i = 0; i < words.length; i++) {
    //         int curind = -1, j, len = words[i].length();
    //         for (j = 0; j < len; j++) {
    //             char ch = words[i].charAt(j);
    //             if (!map.containsKey(ch)) break;
    //             Integer higher = map.get(ch).higher(curind);
    //             if (higher == null) break;
    //             curind = (int)higher;
    //         }
    //         if (j == len) ans++;
    //     }
    //     return ans;
    // }
    
    // method 2
    HashMap<String, Boolean> cache = new HashMap<String, Boolean>();
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if (isSubseq(S, words[i])) ans++;
        }
        return ans;
    }
    private boolean isSubseq(String S, String word) {
        Boolean result = cache.get(word);
        if (result != null) return result;
        int idx = -1;
        for (char ch : word.toCharArray()) {
            idx = S.indexOf(ch, idx+1);
            if (idx == -1) {
                cache.put(word, false);
                return false;
            }
        } 
        cache.put(word, true);
        return true;
    }
}