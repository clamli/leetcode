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
    public List<Integer> findAnagrams(String s, String p) {
        int nonzero = 0;
        int[] count = new int[26];
        for (char ch : p.toCharArray()) {
            if (count[ch-'a'] == 0) nonzero++;
            count[ch-'a']++;
        }
        int left = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            while (count[idx] == 0) {
                int removed = s.charAt(left++)-'a';
                if (count[removed] == 0) nonzero++;
                count[removed]++;
            }
            count[idx]--;
            if (count[idx] == 0) nonzero--;
            if (nonzero == 0) res.add(left);
        }
        return res;
    }
}