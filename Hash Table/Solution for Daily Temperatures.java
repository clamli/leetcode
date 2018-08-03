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
    // method 1 : 960ms
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int res[] = new int[temperatures.length];
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     for (int i = 0; i < temperatures.length; i++) {
    //         if (!map.containsKey(temperatures[i])) map.put(temperatures[i], new ArrayList<>());
    //         map.get(temperatures[i]).add(i);
    //     }
    //     for (int i = 0; i < temperatures.length; i++) {
    //         int minintv = Integer.MAX_VALUE;
    //         for (int t = temperatures[i]+1; t <= 100; t++) {
    //             if (map.containsKey(t)) {
    //                 List<Integer> tmp = map.get(t);
    //                 int s = 0;
    //                 while (s < tmp.size()) {
    //                     int intv = tmp.get(s++) - i;
    //                     if (intv > 0) {
    //                         minintv = Math.min(minintv, intv);
    //                         break;
    //                     }
    //                 }
    //             }
    //         }
    //         if (minintv == Integer.MAX_VALUE) minintv = 0;
    //         res[i] = minintv;
    //     }
    //     return res;
    // }
    
    // method 2 : 221ms
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int res[] = new int[temperatures.length];
    //     for (int i = 0; i < temperatures.length; i++) {
    //         int intv = 0;
    //         for (int j = i + 1; j < temperatures.length; j++) {
    //             if (temperatures[j] > temperatures[i]) {
    //                 intv = j - i;
    //                 break;
    //             }
    //         }
    //         res[i] = intv;
    //     }
    //     return res;
    // }
    
    // method 3 : 93ms
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int res[] = new int[temperatures.length], preintv = 0;
    //     for (int i = 0; i < temperatures.length; i++) {
    //         int intv = 0;
    //         if (i != 0) {
    //             if (temperatures[i] >= temperatures[i-1]) {
    //                 for (int j = preintv; j < temperatures.length; j++) {
    //                     if (temperatures[j] > temperatures[i]) {
    //                         intv = j - i;
    //                         break;
    //                     }
    //                 }
    //             } else {
    //                 for (int j = i + 1; j <= preintv; j++) {
    //                     if (temperatures[j] > temperatures[i]) {
    //                         intv = j - i;
    //                         break;
    //                     }
    //                 }
    //             }
    //         } else {
    //             for (int j = i + 1; j < temperatures.length; j++) {
    //                 if (temperatures[j] > temperatures[i]) {
    //                     intv = j - i;
    //                     break;
    //                 }
    //             }
    //         }
    //         res[i] = intv;
    //         if (intv == 0) preintv = temperatures.length - 1;
    //         else preintv = intv + i;
    //     }
    //     return res;
    // }
    
    // method 4 : 52ms
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!S.empty() && temperatures[i] > temperatures[S.peek()]) {
                int idx = S.pop();
                res[idx] = i - idx;
            }
            S.push(i);
        }
        return res;
    }
}