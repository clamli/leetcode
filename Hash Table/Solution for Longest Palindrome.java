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
    public int longestPalindrome(String s) {
        // Map<Character, Integer> map = new HashMap<>();
        // for (char ch : s.toCharArray()) {
        //     map.put(ch, map.getOrDefault(ch, 0)+1);
        // }
        
        
        int[] cnt_arr = new int[58];
        for (char ch : s.toCharArray()) {
            cnt_arr[ch-'A']++;
        }
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < 58; i++) {
            if (cnt_arr[i] % 2 != 0) {
                flag = true;
                res += cnt_arr[i] - 1;
            } else {
                res += cnt_arr[i];
            }
        }
        return flag ? res+1 : res;
    }
}