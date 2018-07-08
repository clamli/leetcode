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
    public List<List<Integer>> palindromePairs(String[] words) {
        /**
         * 4 situations: 
         * 1. s1 is "", s2 is palindrome
         * 2. s1 is reverse(s2)
         * 3. s1 [0, cut] palindrome, s2 is reverse s1[cut, ]
         * 4. s1 [cut, ] palindrome, s2 is reverse s1[0, cut]
         **/
        
        int size = words.length;
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(words[i], i);
        }
        // 1
        if (map.containsKey("")) {
            int idx1 = map.get("");
            for (String key : map.keySet()) {
                if (isPalindrome(key)) {
                    int idx2 = map.get(key);
                    res.add(Arrays.asList(idx1, idx2));
                    res.add(Arrays.asList(idx2, idx1));
                }
            }
        }
        // 2
        for (String key : map.keySet()) {
            String rev_key = reverse(key);
            if (map.containsKey(rev_key)) {
                int idx1 = map.get(key);
                int idx2 = map.get(rev_key);
                if (idx1 != idx2) {
                    res.add(Arrays.asList(idx1, idx2));
                }
            }
        }
        // 3 & 4
        for (String key : map.keySet()) {
            for (int cut = 1; cut < key.length(); cut++) {
                String first = key.substring(0, cut);
                if (isPalindrome(first)) {
                    String rev_sec = reverse(key.substring(cut));
                    if (map.containsKey(rev_sec)) res.add(Arrays.asList(map.get(rev_sec), map.get(key)));
                }
                first = key.substring(cut);
                if (isPalindrome(first)) {
                    String rev_sec = reverse(key.substring(0, cut));
                    if (map.containsKey(rev_sec)) res.add(Arrays.asList(map.get(key), map.get(rev_sec)));
                }
            }
        }
        return res; 
    }
    
    private boolean isPalindrome(String str) {
        if (str.equals("")) return false;
        int size = str.length();
        for (int i = 0; i <= size/2; i++) {
            if (str.charAt(i) != str.charAt(size-i-1)) return false;
        }
        return true;
    }
    
    private String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
}