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
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, maxlen = 0, cnt = 0, idx;
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            idx = s.charAt(i) - '0';
            map[idx]++;
            if (map[idx] == 1) cnt++;
            while (cnt > 2) {
                idx = s.charAt(left) - '0';
                map[idx]--;
                if (map[idx] == 0) cnt--;
                left++;
            }
            if (cnt == 2) {
                maxlen = Math.max(maxlen, i-left+1);
            }
        }
        if (maxlen == 0) return s.length();
        else return maxlen;
    }
}