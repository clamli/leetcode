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
    public String frequencySort(String s) {
        int len = s.length();
        if (len == 0) return "";
        int[] char_cnt = new int[128];
        for (char ch : s.toCharArray()) {
            char_cnt[ch]++;
        }
        StringBuilder[] sort = new StringBuilder[len+1];
        for (int i = 0; i < 128; i++) {
            if (sort[char_cnt[i]] == null)
                sort[char_cnt[i]] = new StringBuilder("");
            sort[char_cnt[i]].append((char)i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len; i >= 1; i--) {
            if (sort[i] != null) {
                for (int j = 0; j < sort[i].length(); j++) {
                    char[] arr = new char[i];
                    Arrays.fill(arr, sort[i].charAt(j));
                    sb.append(arr);
                }
            }
        }
        return sb.toString();
    }
}