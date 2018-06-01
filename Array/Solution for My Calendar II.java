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

class MyCalendarTwo {
    
    // method 1
//     private TreeMap<Integer, Integer> treeMap;

//     public MyCalendarTwo() {
//         treeMap = new TreeMap<Integer, Integer>();
//     }
    
//     public boolean book(int start, int end) {
//         treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
//         treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
//         int event = 0;
//         for (Integer v : treeMap.values()) {
//             event += v;
//             if (event >= 3) {
//                 treeMap.put(start, treeMap.getOrDefault(start, 0) - 1);
//                 treeMap.put(end, treeMap.getOrDefault(end, 0) + 1);
//                 if (treeMap.get(start) == 0)
//                     treeMap.remove(start);
//                 if (treeMap.get(end) == 0)
//                     treeMap.remove(end);
//                 return false;
//             }
//         }
//         return true;
//     }
    
    
    // method2
    List<int[]> overlaps;
    List<int[]> calendar;
    
    public MyCalendarTwo() {
        calendar = new ArrayList();
        overlaps = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for (int[] iv : overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv : calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
        }
        calendar.add(new int[]{start, end});
        return true;
    }
    
}