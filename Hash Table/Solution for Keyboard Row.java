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
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        set1.addAll(Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'));
        set2.addAll(Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'));
        set3.addAll(Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M'));
        List<String> list = new ArrayList<>();
        for (String word : words) {
            String upperWord = word.toUpperCase();
            if (set1.contains(upperWord.charAt(0))) {
                if (isContain(set1, upperWord)) list.add(word);
            } else if (set2.contains(upperWord.charAt(0))) {
                if(isContain(set2, upperWord)) list.add(word);
            } else if (set3.contains(upperWord.charAt(0))) {
                if(isContain(set3, upperWord)) list.add(word);
            }
        }
        String[] res = list.toArray(new String[0]);
        return res;
    }
    
    private boolean isContain(Set<Character> set, String word) {
        for (char ch : word.toCharArray()) {
            if (!set.contains(ch)) return false;
        }
        return true;
    }
}