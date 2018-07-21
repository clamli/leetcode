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
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        int[] valididx = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ich = findNextChar(count, valididx, i);
            if (ich == -1) return "";
            char ch = (char)(ich+'a');
            sb.append(ch);
            valididx[ch-'a'] = i+k;
            count[ch-'a']--;
        }
        return sb.toString();
    }
    
    private int findNextChar(int[] count, int[] valididx, int index) {
        int maxcnt = Integer.MIN_VALUE, maxidx = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] > maxcnt && index>=valididx[i]) {
                maxcnt = count[i];
                maxidx = i;
            }
        }
        return maxidx;
    }
}