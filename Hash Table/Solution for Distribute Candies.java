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
    // public int distributeCandies(int[] candies) {
    //     int brother = 0, amount = candies.length;
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int candy : candies) {
    //         map.put(candy, map.getOrDefault(candy, 0)+1);
    //         if (map.get(candy) != 1) brother++;
    //     }
    //     int kinds = map.size();
    //     if (2*brother >= amount) return kinds;
    //     else return kinds-(amount/2-brother);
    // }
    
    // method 2
    public int distributeCandies(int[] candies) {
        int different = 0, half = candies.length/2;
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            if (!set.contains(candy)) {
                different++;
                set.add(candy);
                if (different >= half) return half;
            } 
        }
        return different;
    }
}