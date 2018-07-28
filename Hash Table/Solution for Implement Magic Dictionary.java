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

class MagicDictionary {
    
    // Map<Integer, List<String>> map;
    List<String> list;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        // map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String elem : dict) {
            // int len = elem.length();
            // if (!map.containsKey(len)) map.put(len, new ArrayList<>());
            // map.get(len).add(elem);
            list.add(elem);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int len = word.length();
        // if (!map.containsKey(len)) return false;
        // List<String> list = map.get(len);
        for (String str : list) {
            if (str.length() != len) continue;
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != word.charAt(i)) {
                    diff++;
                    if (diff > 1) break;
                }
            }
            if (diff == 1) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */