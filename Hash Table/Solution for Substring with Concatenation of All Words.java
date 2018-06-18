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
    // public List<Integer> findSubstring(String s, String[] words) {
    //     HashMap<String, Integer> wdcnt = new HashMap<String, Integer>();
    //     TreeMap<Integer, String> wdind = new TreeMap<Integer, String>();
    //     List<Integer> ans = new ArrayList<Integer>();
    //     if (words.length == 0 || s.length() == 0) return ans;
    //     int wdlen = words[0].length();
    //     for (String word : words) {
    //         wdcnt.put(word, wdcnt.getOrDefault(word, 0)+1);
    //     }
    //     for (int i = 0; i < s.length()-wdlen+1; i++) {
    //         String word = s.substring(i, i+wdlen);
    //         if (wdcnt.containsKey(word)) {
    //             wdind.put(i, word);
    //         }
    //     }
    //     int upper = s.length()-wdlen*words.length+1;
    //     for (int ind : wdind.keySet()) {
    //         if (ind >= upper) break;
    //         HashMap<String, Integer> tmp = new HashMap<String, Integer>(wdcnt);
    //         int index = ind, start = index;
    //         while (wdind.containsKey(index)) {
    //             String word = wdind.get(index);
    //             if (!tmp.containsKey(word)) {
    //                 break;
    //             }
    //             int newcnt = tmp.get(word)-1;
    //             if (newcnt == 0) tmp.remove(word);
    //             else tmp.put(word, newcnt);
    //             if (tmp.size() == 0) {
    //                 ans.add(start);
    //                 break;
    //             }
    //             index = index+wdlen;
    //         }
    //     }
    //     return ans;
    // }
    
    // method 2
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if (words.length == 0) return ans;
        int wdlen = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        for (int i = 0; i < wdlen; i++) {
            int lfts = i, count = 0;
            Map<String, Integer> tmp = new HashMap<String, Integer>();
            for (int j = i; j <= s.length()-wdlen; j += wdlen) {
                String curstr = s.substring(j, j+wdlen);
                Integer numb = map.get(curstr);
                if (numb != null) {
                    tmp.put(curstr, tmp.getOrDefault(curstr, 0)+1);
                    count++;
                    while (tmp.get(curstr) > numb) {
                        String removed = s.substring(lfts, lfts+wdlen);
                        tmp.put(removed, tmp.get(removed)-1);
                        lfts += wdlen;
                        count--;
                    }
                    if (count == words.length) {
                        ans.add(lfts);
                    }
                } else {
                    lfts = j + wdlen;
                    count = 0;
                    tmp.clear();
                }
            }
        }
        return ans;
    }
}