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
    //     method 1
    //     public List<List<String>> groupAnagrams(String[] strs) {
    //         int size = strs.length;
    //         String[] sstrs = new String[size];
    //         Map<String, List<String>> ans = new HashMap<>();
    //         for (int i = 0; i < size; i++) {
    //             char[] chars = strs[i].toCharArray();
    //             Arrays.sort(chars);
    //             String sorted = new String(chars);
    //             sstrs[i] = sorted;
    //             ans.computeIfAbsent(sstrs[i], k -> new ArrayList<String>()).add(strs[i]);
    //         }
    //         return new ArrayList<>(ans.values());
            
    //     }
    
    // method 2
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] count = new int[26];
        Map<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char ch : str.toCharArray()) count[ch - 'a']++;
            StringBuilder keyb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyb.append('#');
                keyb.append(count[i]);
            }
            String key = keyb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}